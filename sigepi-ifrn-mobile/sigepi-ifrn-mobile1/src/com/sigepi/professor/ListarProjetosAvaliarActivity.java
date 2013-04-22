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
public class ListarProjetosAvaliarActivity extends Activity implements OnItemClickListener, Runnable {
	
	private AdapterListView adapterListView;
	private Button btSalvarHistorico;
	private ListView listView;
	private ProgressDialog progressDialog;
	
	private ArrayList<ItemListView> listInfoConsultas;
	private List<Projeto> listaProjetos;
	private String cpf;
	private RepositorioProjeto repositorioProjeto;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_projetos_avaliar);
		
		listView = (ListView) findViewById(R.id.tela_projeto_listview);
		//listView.setOnItemClickListener(this);

		btSalvarHistorico = (Button) findViewById(R.id.btSalvarHistorico);
		btSalvarHistorico.setOnClickListener(btSalvarHistoricoListener);

		Intent intent = getIntent();
		Bundle paramConsulta = intent.getExtras();
		if(paramConsulta != null)
			cpf = paramConsulta.getString("cpf");

		progressDialog = ProgressDialog.show(ListarProjetosAvaliarActivity.this, "Aguarde", "Processando...");
		
		Thread thread = new Thread(ListarProjetosAvaliarActivity.this);
		thread.start();
	}
	
    @Override
    public void onPause(){
        super.onPause();
        if(repositorioProjeto != null)
        	repositorioProjeto.close();
    }

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Intent intent = new Intent(ListarProjetosAvaliarActivity.this, BuscarProjetoCpfActivity.class);
		Bundle param = new Bundle();

		Projeto c = listaProjetos.get(arg2);

		param.putInt(Projeto.ID, c.getId()); //id da consulta no banco local
		param.putInt(Projeto.ID_PROJETO, c.getId_projeto()); //id da consulta no servidor
		

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
			listaProjetos = clienteRest.getListaProjetosParaAvaliar(cpf);
			listInfoConsultas = new ArrayList<ItemListView>();

			for (Projeto projeto : listaProjetos) {

				ItemListView itens = new ItemListView(projeto.getProjeto());

				listInfoConsultas.add(itens);
			}

			adapterListView = new AdapterListView(this, listInfoConsultas);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		handler.sendEmptyMessage(0);
	}
	
	private void exibirAlerta() {	
		AlertDialog.Builder dialog = new AlertDialog.Builder(ListarProjetosAvaliarActivity.this);
		
		dialog.setMessage("Ao salvar o histórico atual seus dados anteriores serão perdidos. \nDeseja continuar?");
		
		dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface di, int arg) {	
				repositorioProjeto = new RepositorioProjeto(ListarProjetosAvaliarActivity.this);
				//int qtdExcluidas = repositorioProjeto.deletarTodos();
				int qtd = repositorioProjeto.salvarLista(listaProjetos);
				
				Toast.makeText(ListarProjetosAvaliarActivity.this, 
						"Projetos salvos: " + qtd ,
					//	"\nProjetos excluidos: " + qtdExcluidas, 
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
				Toast.makeText(ListarProjetosAvaliarActivity.this, "Nenhum projeto foi encontrado para avaliar com este CPF.", Toast.LENGTH_LONG).show();
			} else if(listView.getCount() == 1){
				Toast.makeText(ListarProjetosAvaliarActivity.this, listView.getCount() + " Projeto encontrado para avaliar", Toast.LENGTH_LONG).show();	
			} else {
				Toast.makeText(ListarProjetosAvaliarActivity.this, listView.getCount() + " Projetos encontrados para a sua avaliação", Toast.LENGTH_LONG).show();		
			}
		}
	};
}

