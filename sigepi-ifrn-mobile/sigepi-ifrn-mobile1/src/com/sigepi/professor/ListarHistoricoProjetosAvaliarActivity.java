package com.sigepi.professor;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.PrivateCredentialPermission;

import com.sigepi.professor.banco.RepositorioProjetoAvaliar;
import com.sigepi.professor.listview.AdapterListView;
import com.sigepi.professor.listview.ItemListView;
import com.sigepi.professor.modelo.ProjetoAvaliar;

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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class ListarHistoricoProjetosAvaliarActivity extends Activity implements
		OnItemClickListener, Runnable {

	private List<ProjetoAvaliar> listarProjetosAvaliar;
	private ArrayList<ItemListView> listInfoConsultas;
	private AdapterListView adapterListView;
	private ListView listView;
	private RepositorioProjetoAvaliar repositorioProjetoAvaliar;
	private ProgressDialog progressDialog;
	private Thread thread;
	private Button btLimparHistorico;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listar_historico_projetos_avaliar);

		listView = (ListView) findViewById(R.id.tela_projetos_list);
		listView.setOnItemClickListener(this);

		btLimparHistorico = (Button) findViewById(R.id.btLimparHistorico);
		btLimparHistorico.setOnClickListener(btLimparHistoricoListener);

		repositorioProjetoAvaliar = new RepositorioProjetoAvaliar(
				ListarHistoricoProjetosAvaliarActivity.this);

		progressDialog = progressDialog.show(
				ListarHistoricoProjetosAvaliarActivity.this, "Aguarde",
				"Processandro...");

		thread = new Thread(ListarHistoricoProjetosAvaliarActivity.this);
		thread.start();
	}

	@Override
	public void onPause() {
		super.onPause();
		repositorioProjetoAvaliar.close();
	}

	@Override
	public void run() {
		try {
			listarProjetosAvaliar = repositorioProjetoAvaliar.listarProjetos();

			listInfoConsultas = new ArrayList<ItemListView>();	
			
			for (ProjetoAvaliar projeto : listarProjetosAvaliar) {

								
				ItemListView itens = new ItemListView(projeto.getProjetoAvaliar());

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
		ProjetoAvaliar p = listarProjetosAvaliar.get(arg2);
		showCustomDialog(p);
	}

	private void showCustomDialog(ProjetoAvaliar p){}
	
	private OnClickListener btLimparHistoricoListener = new OnClickListener() {
		public void onClick(View v) {
			exibirAlerta();
		}
	};
	
	private void exibirAlerta() {
		final RepositorioProjetoAvaliar rc = new RepositorioProjetoAvaliar(ListarHistoricoProjetosAvaliarActivity.this);
		
		AlertDialog.Builder dialog = new AlertDialog.Builder(ListarHistoricoProjetosAvaliarActivity.this);
		dialog.setMessage("Deseja excluir todos os projetos do seu histórico? \n(Essa ação não irá excluir as informações no servidor.)");
	
		dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface di, int arg) {
				int qtd = rc.deletarTodos();
				Toast.makeText(ListarHistoricoProjetosAvaliarActivity.this, "Projetos excluidos: " + qtd, Toast.LENGTH_LONG).show();
				
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
