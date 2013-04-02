package com.example.sigepi_mobile;

import java.util.ArrayList;
import java.util.List;


import br.edu.ifrn.sigepi.banco.RepositorioEdital;
import br.edu.ifrn.sigepi.listview.AdapterListView;
import br.edu.ifrn.sigepi.listview.ItemListView;
import br.edu.ifrn.sigepi.modelo.Edital;
import br.edu.ifrn.sigepi.ws.ClientRest;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

@SuppressLint("HandlerLeak")
public class EditaisAbertosActivity extends Activity implements	OnItemClickListener, Runnable {

	private ListView listView;
	private AdapterListView adapterListView;
	private List<Edital> listaEditais;
	private ProgressDialog progressDialog;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_editais_abertos);

		listView = (ListView) findViewById(R.id.tela_edital_listview);
		listView.setOnItemClickListener(this);
		 progressDialog = ProgressDialog.show(EditaisAbertosActivity.this,
		 "Aguarde", "Processando...");
		 Thread thread = new Thread(EditaisAbertosActivity.this);
		 thread.start();
	}

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Edital e = listaEditais.get(arg2);
		 showCustomDialog(e);
	}

	
	  private void showCustomDialog(Edital edital) { final Dialog dialog = new
	  
			  
	  Dialog(this); dialog.setContentView(R.layout.custom_dialog);
	  dialog.setTitle("Informações da edital");
	  
	  TextView dialogEdital = (TextView) dialog.findViewById(R.id.exibiNomeEditalDialog); 
	  
	  dialogEdital.setText(edital.getTitulo());
	 	  
	  final Button ok = (Button) dialog.findViewById(R.id.bt_ok);
	  
	  ok.setOnClickListener(new View.OnClickListener() {
		  
		  public void onClick(View v) { 
			  dialog.dismiss();
	     } 
		  
	    });
	  
	  dialog.show(); 
	  }
	

	public void run() {
		ClientRest clienteRest = new ClientRest();
		
		try {

			listaEditais = clienteRest.getListaEditais1();// .getListaMes();

			ArrayList<ItemListView> listInfoEditais = new ArrayList<ItemListView>();

			for (Edital edital : listaEditais) {

				ItemListView itens = new ItemListView(edital.getTitulo());

				listInfoEditais.add(itens);
			}

			adapterListView = new AdapterListView(this, listInfoEditais);
		} catch (Exception e) {
			e.printStackTrace();
		}

		handler.sendEmptyMessage(0);
	}

	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			progressDialog.dismiss();

			listView.setAdapter(adapterListView);
		}
	};

}
