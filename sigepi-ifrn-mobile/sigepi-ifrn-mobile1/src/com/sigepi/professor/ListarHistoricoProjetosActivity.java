package com.sigepi.professor;

import java.util.ArrayList;
import java.util.List;

import com.sigepi.professor.banco.RepositorioEdital;
import com.sigepi.professor.banco.RepositorioProjeto;
import com.sigepi.professor.listview.AdapterListView;
import com.sigepi.professor.listview.ItemListView;
import com.sigepi.professor.modelo.Edital;
import com.sigepi.professor.modelo.Projeto;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
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
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ListarHistoricoProjetosActivity extends Activity  implements
OnItemClickListener, Runnable {
	
	private List<Projeto> listaProjetos;
	private ArrayList<ItemListView> listInfoConsultas;
	private AdapterListView adapterListView;
	private ListView listView;
	private RepositorioProjeto repositorioProjeto;
	private ProgressDialog progressDialog;
	private Thread thread;
	private Button btLimparHistorico;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listar_historico_projetos);

		listView = (ListView) findViewById(R.id.tela_projetos_listview);
		listView.setOnItemClickListener(this);

		btLimparHistorico = (Button) findViewById(R.id.btLimparHistorico);
		btLimparHistorico.setOnClickListener(btLimparHistoricoListener);

		repositorioProjeto = new RepositorioProjeto(ListarHistoricoProjetosActivity.this);

		progressDialog = ProgressDialog.show(ListarHistoricoProjetosActivity.this,
				"Aguarde", "Processando...");

		thread = new Thread(ListarHistoricoProjetosActivity.this);
		thread.start();
	}
	
	@Override
    public void onPause(){
        super.onPause();
        repositorioProjeto.close();

    }

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Projeto p = listaProjetos.get(arg2);
		showCustomDialog(p);
	}

	private void showCustomDialog(Projeto p) {
		final Dialog dialog = new Dialog(this);
		dialog.setContentView(R.layout.custom_dialog);
		dialog.setTitle("Informações do projeto");

		TextView dialogProjeto = (TextView) dialog.findViewById(R.id.exibiNomeEditalDialog);
		
		dialogProjeto.setText(p.getProjeto());
		
		final Button ok = (Button) dialog.findViewById(R.id.bt_ok);

		ok.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				dialog.dismiss();
			}
		});

		dialog.show();
	}

	private OnClickListener btLimparHistoricoListener = new OnClickListener() {
		public void onClick(View v) {
			exibirAlerta();
		}
	};

	public void run() {
		
		try {
			listaProjetos = repositorioProjeto.listarProjetos();

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
		final RepositorioProjeto rc = new RepositorioProjeto(ListarHistoricoProjetosActivity.this);
		
		AlertDialog.Builder dialog = new AlertDialog.Builder(ListarHistoricoProjetosActivity.this);
		dialog.setMessage("Deseja excluir todos os projetos do seu histórico? \n(Essa ação não irá excluir as informações no servidor.)");
	
		dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface di, int arg) {
				int qtd = rc.deletarTodos();
				Toast.makeText(ListarHistoricoProjetosActivity.this, "Projetos excluidos: " + qtd, Toast.LENGTH_LONG).show();
				
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
