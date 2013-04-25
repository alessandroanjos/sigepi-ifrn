package com.sigepi.professor;

import java.util.ArrayList;
import java.util.List;

import com.sigepi.professor.banco.RepositorioEdital;
import com.sigepi.professor.listview.AdapterListView;
import com.sigepi.professor.listview.ItemListView;
import com.sigepi.professor.modelo.Edital;


import android.annotation.SuppressLint;
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

@SuppressLint("HandlerLeak")
public class ListarHistoricoEditaisActivity extends Activity implements
OnItemClickListener, Runnable {
	
	private List<Edital> listaEdital;
	private ArrayList<ItemListView> listInfoConsultas;
	private AdapterListView adapterListView;
	private ListView listView;
	private RepositorioEdital repositorioEdital;
	private ProgressDialog progressDialog;
	private Thread thread;
	private Button btLimparHistorico;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listar_historico);

		listView = (ListView) findViewById(R.id.tela_editais_listView);
		listView.setOnItemClickListener(this);

		btLimparHistorico = (Button) findViewById(R.id.btLimparHistorico);
		btLimparHistorico.setOnClickListener(btLimparHistoricoListener);

		repositorioEdital = new RepositorioEdital(ListarHistoricoEditaisActivity.this);

		progressDialog = ProgressDialog.show(ListarHistoricoEditaisActivity.this,
				"Aguarde", "Processando...");

		thread = new Thread(ListarHistoricoEditaisActivity.this);
		thread.start();
	}
	
	@Override
    public void onPause(){
        super.onPause();
        repositorioEdital.close();

    }

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Edital e = listaEdital.get(arg2);
		showCustomDialog(e);
	}

	private void showCustomDialog(Edital e) {
		final Dialog dialog = new Dialog(this);
		dialog.setContentView(R.layout.custom_dialog);
		dialog.setTitle("Informações do edital");

		TextView dialogEdital = (TextView) dialog.findViewById(R.id.exibiNomeEditalDialog);
		
		dialogEdital.setText(e.getTitulo());
		
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
			listaEdital = repositorioEdital.listarEditais();

			listInfoConsultas = new ArrayList<ItemListView>();	
			
			for (Edital edital : listaEdital) {

								
				ItemListView itens = new ItemListView(edital.getTitulo());

				listInfoConsultas.add(itens);
			}

			adapterListView = new AdapterListView(this, listInfoConsultas);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		handler.sendEmptyMessage(0);
	}

	private void exibirAlerta() {
		final RepositorioEdital rc = new RepositorioEdital(ListarHistoricoEditaisActivity.this);
		
		AlertDialog.Builder dialog = new AlertDialog.Builder(ListarHistoricoEditaisActivity.this);
		dialog.setMessage("Deseja excluir todos os editais do seu histórico? \n(Essa ação não irá excluir as informações no servidor.)");
	
		dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface di, int arg) {
				int qtd = rc.deletarTodos();
				Toast.makeText(ListarHistoricoEditaisActivity.this, "Editais excluidos: " + qtd, Toast.LENGTH_LONG).show();
				
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
