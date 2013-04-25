package com.sigepi.professor;

import java.util.ArrayList;
import java.util.List;

import com.sigepi.professor.banco.RepositorioProjeto;
import com.sigepi.professor.banco.RepositorioProjetoAvaliar;
import com.sigepi.professor.banco.RepositorioProjetoStatusCampus;
import com.sigepi.professor.listview.AdapterListView;
import com.sigepi.professor.listview.ItemListView;
import com.sigepi.professor.modelo.Projeto;
import com.sigepi.professor.modelo.ProjetoAvaliar;
import com.sigepi.professor.modelo.ProjetoStatusCampus;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
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

public class ListarHistoricoProjetosStatusCampusActivity extends Activity implements
OnItemClickListener, Runnable {
	
	private List<ProjetoStatusCampus> listaProjetosStatus;
	private ArrayList<ItemListView> listInfoConsultas;
	private AdapterListView adapterListView;
	private ListView listView;
	private RepositorioProjetoStatusCampus repositorioProjetoStatus;
	private ProgressDialog progressDialog;
	private Thread thread;
	private Button btLimparHistorico;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listar_historico_projetos_campus);

		listView = (ListView) findViewById(R.id.list);
		listView.setOnItemClickListener(this);

		btLimparHistorico = (Button) findViewById(R.id.btLimparHistorico);
		btLimparHistorico.setOnClickListener(btLimparHistoricoListener);

		repositorioProjetoStatus = new RepositorioProjetoStatusCampus(
				ListarHistoricoProjetosStatusCampusActivity.this);

		progressDialog = progressDialog.show(
				ListarHistoricoProjetosStatusCampusActivity.this, "Aguarde",
				"Processandro...");

		thread = new Thread(ListarHistoricoProjetosStatusCampusActivity.this);
		thread.start();
	}

	@Override
	public void onPause() {
		super.onPause();
		repositorioProjetoStatus.close();
	}
	
	@Override
	public void run() {
		try {
			listaProjetosStatus = repositorioProjetoStatus.listarProjetosStatusCampus();

			listInfoConsultas = new ArrayList<ItemListView>();	
			
			for (ProjetoStatusCampus projeto : listaProjetosStatus) {

								
				ItemListView itens = new ItemListView(projeto.getProjetoStatusCampus());

				listInfoConsultas.add(itens);
			}

			adapterListView = new AdapterListView(this, listInfoConsultas);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		handler.sendEmptyMessage(0);
		
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		ProjetoStatusCampus p = listaProjetosStatus.get(arg2);
		showCustomDialog(p);
		
	}
private void showCustomDialog(ProjetoStatusCampus p){}
	
	private OnClickListener btLimparHistoricoListener = new OnClickListener() {
		public void onClick(View v) {
			exibirAlerta();
		}
	};
	private void exibirAlerta() {
		final RepositorioProjetoAvaliar rc = new RepositorioProjetoAvaliar(ListarHistoricoProjetosStatusCampusActivity.this);
		
		AlertDialog.Builder dialog = new AlertDialog.Builder(ListarHistoricoProjetosStatusCampusActivity.this);
		dialog.setMessage("Deseja excluir todos os projetos do seu histórico? \n(Essa ação não irá excluir as informações no servidor.)");
	
		dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface di, int arg) {
				int qtd = rc.deletarTodos();
				Toast.makeText(ListarHistoricoProjetosStatusCampusActivity.this, "Projetos excluidos: " + qtd, Toast.LENGTH_LONG).show();
				
				finish();
				startActivity(getIntent());
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
			listView.setAdapter(adapterListView);
			progressDialog.dismiss();
		}
	};


}
