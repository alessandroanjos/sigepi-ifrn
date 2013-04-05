package com.example.sigepi_mobile;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrn.sigepi.listview.AdapterListView;
import br.edu.ifrn.sigepi.listview.ItemListView;
import br.edu.ifrn.sigepi.modelo.Edital;
import br.edu.ifrn.sigepi.modelo.Projeto;
import br.edu.ifrn.sigepi.ws.ClientRest;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class ProjetosParaAvaliarActivity extends Activity implements OnItemClickListener, Runnable {
	public ListView listarProjetos;
	private AdapterListView adapterListView;
	private List<Projeto> listaProjetos;
	private ProgressDialog progressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_projetos_para_avaliar);
		
		
		listarProjetos = (ListView) findViewById(R.id.tela_Projetos_avaliar);
		
		listarProjetos.setOnItemClickListener(this);
		 progressDialog = ProgressDialog.show(ProjetosParaAvaliarActivity.this,
		 "Aguarde", "Processando...");
		 Thread thread = new Thread(ProjetosParaAvaliarActivity.this);
		 thread.start();
	
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_projetos_para_avaliar, menu);
		return true;
	}

	@Override
	public void run() {
		ClientRest clienteRest = new ClientRest();
		
		try {

			listaProjetos = clienteRest.getListaProjetos();// .getListaMes();

			ArrayList<ItemListView> listInfoProjeto = new ArrayList<ItemListView>();

			for (Projeto p : listaProjetos) {

				ItemListView itens = new ItemListView(p.getNomeDoProjeto());

				listInfoProjeto.add(itens);
			}

			adapterListView = new AdapterListView(this, listInfoProjeto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		handler.sendEmptyMessage(0);
	}
	
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			progressDialog.dismiss();

			listarProjetos.setAdapter(adapterListView);
		}
	};
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Projeto e = listaProjetos.get(arg2);
		 showCustomDialog(e);
		
	}


	private void showCustomDialog(Projeto projeto) {
		 final Dialog dialog = new
				  
				  
				  Dialog(this); dialog.setContentView(R.layout.custom_dialog_projetos);
				  dialog.setTitle("Você tem 5 dias  para avaliar!");
				  
				  TextView dialogProjeto = (TextView) dialog.findViewById(R.id.exibiNomeProjetoDialog); 
				  
				  dialogProjeto.setText(projeto.getNomeDoProjeto());
				 	  
				  final Button ok = (Button) dialog.findViewById(R.id.bt_ok);
				  
				  ok.setOnClickListener(new View.OnClickListener() {
					  
					  public void onClick(View v) { 
						  dialog.dismiss();
				     } 
					  
				    });
				  
				  dialog.show(); 
				  
		
	}

}
//ArrayAdapter é usado para carregar os dados de um ListView
