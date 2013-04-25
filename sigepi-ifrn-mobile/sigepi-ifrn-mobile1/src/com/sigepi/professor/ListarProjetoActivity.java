package com.sigepi.professor;

import java.util.ArrayList;
import java.util.List;

import com.sigepi.professor.banco.RepositorioProjeto;
import com.sigepi.professor.listview.AdapterListView;
import com.sigepi.professor.listview.ItemListView;
import com.sigepi.professor.modelo.Edital;
import com.sigepi.professor.modelo.Projeto;
import com.sigepi.professor.ws.ClientRest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

@SuppressLint("HandlerLeak")
public class ListarProjetoActivity extends Activity implements OnItemClickListener, Runnable {
	private AdapterListView adapterListView;
	private Button btSalvarHistorico;
	private ListView listView;
	private ProgressDialog progressDialog;
	
	private ArrayList<ItemListView> listInfoEditais;
	private List<Projeto> listaProjetos;
	private String cpf;
	private RepositorioProjeto repositorioProjeto;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_projetos);
		
		listView = (ListView) findViewById(R.id.tela_projeto_listview);
		//listView.setOnItemClickListener(this);

		btSalvarHistorico = (Button) findViewById(R.id.btSalvarHistorico);
		btSalvarHistorico.setOnClickListener(btSalvarHistoricoListener);

		Intent intent = getIntent();
		Bundle paramConsulta = intent.getExtras();
		if(paramConsulta != null)
			cpf = paramConsulta.getString("cpf");

		progressDialog = ProgressDialog.show(ListarProjetoActivity.this, "Aguarde", "Processando...");
		
		Thread thread = new Thread(ListarProjetoActivity.this);
		thread.start();
	}
	
    @Override
    public void onPause(){
        super.onPause();
        if(repositorioProjeto != null)
        	repositorioProjeto.close();
    }

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Intent intent = new Intent(ListarProjetoActivity.this, BuscarProjetoCpfActivity.class);
		Bundle param = new Bundle();

		Projeto p = listaProjetos.get(arg2);

		param.putInt(Projeto.ID, p.getId()); //id da consulta no banco local
		param.putString(Projeto.PROJETO, p.getProjeto());
		

		intent.putExtras(param);
		startActivity(intent);
	}

	private OnClickListener btSalvarHistoricoListener = new OnClickListener() {
		public void onClick(View v) {
			exibirAlerta();
		}
	};

	public void run() {
		ClientRest clienteRest = new ClientRest();
		
		try {
			listaProjetos = clienteRest.getListaMeusProjetos(cpf);
			listInfoEditais = new ArrayList<ItemListView>();

			for (Projeto projeto : listaProjetos) {

				ItemListView itens = new ItemListView(projeto.getProjeto());

				listInfoEditais.add(itens);
			}
			
			adapterListView = new AdapterListView(this, listInfoEditais);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		handler.sendEmptyMessage(0);
	}
	
	private void exibirAlerta() {	
		AlertDialog.Builder dialog = new AlertDialog.Builder(ListarProjetoActivity.this);
		
		dialog.setMessage("Ao salvar seu histórico seus dados anteriores serão perdidos. \nDeseja continuar?");
		
		dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface di, int arg) {	
				repositorioProjeto = new RepositorioProjeto(ListarProjetoActivity.this);
				int qtdExcluidas = repositorioProjeto.deletarTodos();
				int qtd = repositorioProjeto.salvarLista(listaProjetos);
				
				
				
				Toast.makeText(ListarProjetoActivity.this, 
						"Projetos salvos: " + qtd +
						"\nProjetos excluidas: " + qtdExcluidas, 
						Toast.LENGTH_LONG).show();
			}
		});

		dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface di, int arg) {
				
			}
		});
		
		dialog.setTitle("Aviso");
		dialog.show();
	}
	
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			progressDialog.dismiss();
			listView.setAdapter(adapterListView);

			if(listView.getCount() == 0){
				Toast.makeText(ListarProjetoActivity.this, "Nenhum projeto encontrado para este CPF.", Toast.LENGTH_LONG).show();
			} else if(listView.getCount() == 1){
				Toast.makeText(ListarProjetoActivity.this, listView.getCount() + " Projeto encontrado", Toast.LENGTH_LONG).show();	
			} else {
				Toast.makeText(ListarProjetoActivity.this, listView.getCount() + " Projetos encontrados", Toast.LENGTH_LONG).show();		
			}
		}
	};
}

