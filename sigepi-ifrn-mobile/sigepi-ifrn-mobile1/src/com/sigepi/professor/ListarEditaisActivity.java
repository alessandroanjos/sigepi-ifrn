package com.sigepi.professor;

import java.util.ArrayList;
import java.util.List;

import com.sigepi.professor.banco.RepositorioEdital;
import com.sigepi.professor.listview.AdapterListView;
import com.sigepi.professor.listview.ItemListView;
import com.sigepi.professor.modelo.Edital;
import com.sigepi.professor.ws.ClientRest;

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
public class ListarEditaisActivity extends Activity implements	OnItemClickListener, Runnable {
	
	private ListView listView;
	private AdapterListView adapterListView;
	private List<Edital> listaEditais;
	private ProgressDialog progressDialog;
	private Button btSalvarHistorico;
	
	private RepositorioEdital repositorioEdital;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_editais_abertos);
		
		
        
        

		listView = (ListView) findViewById(R.id.tela_edital_listview);
		listView.setOnItemClickListener(this);
		
		btSalvarHistorico = (Button) findViewById(R.id.btSalvarHistorico);
		btSalvarHistorico.setOnClickListener(btSalvarHistoricoListener);
		
		
		 progressDialog = ProgressDialog.show(ListarEditaisActivity.this,
		 "Aguarde", "Processando...");
		 Thread thread = new Thread(ListarEditaisActivity.this);
		 thread.start();
	}

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Edital e = listaEditais.get(arg2);
		 showCustomDialog(e);
	}

	
	  private void showCustomDialog(Edital edital) { final Dialog dialog = new
	  
			  
	  Dialog(this); dialog.setContentView(R.layout.custom_dialog);
	  dialog.setTitle("Informações do edital");
	  
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
	
	  private OnClickListener btSalvarHistoricoListener = new OnClickListener() {
			public void onClick(View v) {
				exibirAlerta();
			}
		};
		
		private void exibirAlerta() {	
			AlertDialog.Builder dialog = new AlertDialog.Builder(ListarEditaisActivity.this);
			dialog.setMessage("Ao salvar seu historico seus dados anteriores serão perdidos. \nDeseja continuar?");
			
			dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface di, int arg) {	
					repositorioEdital = new RepositorioEdital(ListarEditaisActivity.this);
					int qtdExcluidas = repositorioEdital.deletarTodos();
					int qtd = repositorioEdital.salvarLista(listaEditais);

					Toast.makeText(ListarEditaisActivity.this, 
							"Editais salvos: " + qtd +
							"\nConsultas excluidas: " + qtdExcluidas, 
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

	public void run() {
		ClientRest clienteRest = new ClientRest();
		
		try {

			listaEditais = clienteRest.getListaEditais();// .getListaMes();

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
