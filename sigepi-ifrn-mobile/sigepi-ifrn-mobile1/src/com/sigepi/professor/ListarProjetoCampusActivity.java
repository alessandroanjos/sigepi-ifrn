package com.sigepi.professor;

import java.util.ArrayList;
import java.util.List;

import com.sigepi.professor.banco.RepositorioProjeto;
import com.sigepi.professor.banco.RepositorioProjetoStatusCampus;
import com.sigepi.professor.listview.AdapterListView;
import com.sigepi.professor.listview.ItemListView;
import com.sigepi.professor.modelo.Projeto;
import com.sigepi.professor.modelo.ProjetoStatusCampus;
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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

@SuppressLint("HandlerLeak")
public class ListarProjetoCampusActivity extends Activity implements OnItemClickListener, Runnable {
	private AdapterListView adapterListView;
	private Button btSalvarHistorico;
	private ListView listView;
	private ProgressDialog progressDialog;
	
	private ArrayList<ItemListView> listInfoConsultas;
	private List<ProjetoStatusCampus> listaProjetos;
	private String cpf;
	private RepositorioProjetoStatusCampus repositorioProjetoStatusCampus;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_projetos_campus);
		
		listView = (ListView) findViewById(R.id.tela_projeto_listview);
		//listView.setOnItemClickListener(this);

		btSalvarHistorico = (Button) findViewById(R.id.btSalvarHistorico);
		btSalvarHistorico.setOnClickListener(btSalvarHistoricoListener);

		Intent intent = getIntent();
		Bundle paramConsulta = intent.getExtras();
		if(paramConsulta != null)
			cpf = paramConsulta.getString("cpf");

		progressDialog = ProgressDialog.show(ListarProjetoCampusActivity.this, "Aguarde", "Processando...");
		
		Thread thread = new Thread(ListarProjetoCampusActivity.this);
		thread.start();
	}
	
    @Override
    public void onPause(){
        super.onPause();
        if(repositorioProjetoStatusCampus != null)
        	repositorioProjetoStatusCampus.close();
    }

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Intent intent = new Intent(ListarProjetoCampusActivity.this, BuscarProjetoCpfActivity.class);
		Bundle param = new Bundle();

		ProjetoStatusCampus p = listaProjetos.get(arg2);

		param.putInt(ProjetoStatusCampus.ID, p.getId()); //id da consulta no banco local
		param.putString(ProjetoStatusCampus.PROJETO_STATUS_CAMPUS, p.getProjetoStatusCampus()); //id da consulta no servidor
		

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
			listaProjetos = clienteRest.getStatusProjetosCampus(cpf);
			listInfoConsultas = new ArrayList<ItemListView>();

			for (ProjetoStatusCampus projeto : listaProjetos) {

				ItemListView itens = new ItemListView(projeto.getProjetoStatusCampus());

				listInfoConsultas.add(itens);
			}
			
			adapterListView = new AdapterListView(this, listInfoConsultas);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		handler.sendEmptyMessage(0);
	}
	
	private void exibirAlerta() {	
		AlertDialog.Builder dialog = new AlertDialog.Builder(ListarProjetoCampusActivity.this);
		
		dialog.setMessage("Ao salvar seu historico seus dados anteriores serão perdidos. \nDeseja continuar?");
		
		dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface di, int arg) {	
				repositorioProjetoStatusCampus = new RepositorioProjetoStatusCampus(ListarProjetoCampusActivity.this);
				//int qtdExcluidas = repositorioProjeto.deletarTodos();
				int qtd = repositorioProjetoStatusCampus.salvarLista(listaProjetos);
				
				
				
				Toast.makeText(ListarProjetoCampusActivity.this, 
						"Consultas salvas: " + qtd ,
					//	"\nConsultas excluidas: " + qtdExcluidas, 
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

			if ( ClientRest.cod500 == true) {
				Toast.makeText(ListarProjetoCampusActivity.this,
						"AVISO: Desculpe, mas você não é um Coordenador Cadastrado no Sistema.",
						Toast.LENGTH_LONG).show();
				ClientRest.cod500=false;
				
			} else {

			   if (listView.getCount() == 0) {
					Toast.makeText(
							ListarProjetoCampusActivity.this,
							"Nenhum projeto do seu campus encontrado para este CPF.",
							Toast.LENGTH_LONG).show();
				} else if (listView.getCount() == 1) {
					Toast.makeText(ListarProjetoCampusActivity.this,
							listView.getCount() + " Projeto encontrado no seu Campus",
							Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(ListarProjetoCampusActivity.this,
							listView.getCount() + " Projetos encontrados em seu Campus",
							Toast.LENGTH_LONG).show();
				}
			}
		}
	};


}
