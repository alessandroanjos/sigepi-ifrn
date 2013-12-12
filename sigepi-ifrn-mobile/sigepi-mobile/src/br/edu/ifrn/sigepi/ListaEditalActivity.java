package br.edu.ifrn.sigepi;

import java.util.ArrayList;
import java.util.List;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.ifrn.sigepi.adapter.ListaEditalAdapter;
import br.edu.ifrn.sigepi.listview.AdapterListView;
import br.edu.ifrn.sigepi.listview.ItemListViewEdital;
import br.edu.ifrn.sigepi.modelo.Edital;
import br.edu.ifrn.sigepi.util.ListaMensagens;
import br.edu.ifrn.sigepi.ws.ClientRest;

/**
 * 
 * @author Alessandro
 *
 */
public class ListaEditalActivity extends AndroidGenericActivity<List<Edital>> implements OnItemClickListener, Runnable{
	
	private ListView listaEdital;
	private List<Edital> editais;
	private ListaEditalAdapter adapter;
	private ProgressDialog progressDialog;
	private AdapterListView adapterListView;
	private ListaMensagens mensagens = new ListaMensagens();
	
	private static final int REQUEST_QRCODE = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_edital);
		
		((TextView) findViewById(R.id.text_cabecalho)).setText(getString(R.string.label_lista_rota));
		
		listaEdital = (ListView) findViewById(R.id.list);
		
		progressDialog = ProgressDialog.show(ListaEditalActivity.this, "Aguarde", "Processando...");
		Thread thread = new Thread(ListaEditalActivity.this);
		thread.start();
		processarRequisicao();
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		ArrayList<Edital> array = new ArrayList<Edital>();
		if (editais != null) {
			array.addAll(editais);
		}
		outState.putSerializable(getString(R.string.intent_extra_1), array);
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		//processarRequisicao();
	}
	/*@Override
	public void onPostExecuteTask(List<Edital> result) {
		
		if (result != null && result.size()>0){
			editais = result;
			adapter = new ListaEditalAdapter(ListaEditalActivity.this, result);
			listaEdital.setAdapter(adapter);
		} else {
			adicionarEMostrarErro("Não há dados a serem exibidos.");
			finish();
		}		
	}*/

	@Override
	public List<Edital> doInBackgroundTask(String... params) {
		List<Edital> result = null;
		
		/*try {
			//result = bd.getAllMedicoesByDataAtual();
		result = null;
		} catch (GenericDAOException e) {
			adicionarEMostrarErro("Erro no banco de dados.");
		}*/
		
		return result;
	}
	
	/*public void run() {
		ClientRest clienteRest = new ClientRest();
		SharedPreferences config = getSharedPreferences("config", MODE_PRIVATE);

		try {
			editais = clienteRest.getListaEditais(config);// .getListaMes();
			if (editais != null && editais.size() > 0) {
				ArrayList<ItemListViewEdital> listInfoEditais = new ArrayList<ItemListViewEdital>();
				
				for (Edital edital : editais) {
					ItemListViewEdital itens = new ItemListViewEdital(edital.getTitulo());
					listInfoEditais.add(itens);
				}
				adapterListView = new AdapterListView(this, listInfoEditais);
			} else {
				adicionarEMostrarErro("Não há dados a serem exibidos.");
				finish();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		handler.sendEmptyMessage(0);
	}*/

	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			progressDialog.dismiss();
			listaEdital.setAdapter(adapterListView);
			
			if (listaEdital.getCount() == 0) {
				adicionarEMostrarErro("Não há editais a serem exibidos.");
				finish();
			} else if(listaEdital.getCount() == 1){
				Toast.makeText(ListaEditalActivity.this, listaEdital.getCount() + " Edital aberto", Toast.LENGTH_LONG).show();	
			} else {
				Toast.makeText(ListaEditalActivity.this, listaEdital.getCount() + " Editais abertos", Toast.LENGTH_LONG).show();		
			}
		}
	};

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPostExecuteTask(List<Edital> result) {

	}

	@Override
	public void run() {
		ClientRest clienteRest = new ClientRest();
		SharedPreferences config = getSharedPreferences("config", MODE_PRIVATE);

		try {
			editais = clienteRest.getListaEditais(config);// .getListaMes();
			if (editais != null && editais.size() > 0) {
				ArrayList<ItemListViewEdital> listInfoEditais = new ArrayList<ItemListViewEdital>();
				
				for (Edital edital : editais) {
					ItemListViewEdital itens = new ItemListViewEdital(edital.getTitulo());
					listInfoEditais.add(itens);
				}
				adapterListView = new AdapterListView(this, listInfoEditais);
			} else {
				atualizarListaEditais();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		handler.sendEmptyMessage(0);
	}
	
	protected void atualizarListaEditais(){
		editais = SplashActivity.sigepiMobileDatabase.listarEditais();
		
		if (editais != null && editais.size() > 0) {
			ArrayList<ItemListViewEdital> listInfoEditais = new ArrayList<ItemListViewEdital>();
			for (Edital edital : editais) {
				ItemListViewEdital itens = new ItemListViewEdital(edital.getTitulo());
				listInfoEditais.add(itens);
			}
			adapterListView = new AdapterListView(this, listInfoEditais);
		} else {
			adicionarEMostrarErro("Não há editais para serem exibidos.");
			finish();
		}
	}
}
