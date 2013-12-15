package br.edu.ifrn.sigepi;

import java.util.ArrayList;
import java.util.List;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.ifrn.sigepi.adapter.ListaEditalAdapter;
import br.edu.ifrn.sigepi.listview.AdapterListView;
import br.edu.ifrn.sigepi.listview.AdapterListViewProjeto;
import br.edu.ifrn.sigepi.listview.ItemListViewEdital;
import br.edu.ifrn.sigepi.listview.ItemListViewProjeto;
import br.edu.ifrn.sigepi.modelo.Edital;
import br.edu.ifrn.sigepi.modelo.Projeto;
import br.edu.ifrn.sigepi.util.ListaMensagens;
import br.edu.ifrn.sigepi.ws.ClientRest;

/**
 * 
 * @author Alessandro
 *
 */
public class ListaProjetosActivity extends AndroidGenericActivity<List<Projeto>> implements OnItemClickListener, Runnable{
	
	private ListView listaProjeto;
	private List<Projeto> projetos;
	private ListaEditalAdapter adapter;
	private ProgressDialog progressDialog;
	private AdapterListViewProjeto adapterListView;
	private ListaMensagens mensagens = new ListaMensagens();
	private String cpf;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_projetos);
		
		((TextView) findViewById(R.id.text_cabecalho)).setText(getString(R.string.label_lista_projetos));
		
		listaProjeto = (ListView) findViewById(R.id.list);
		
		Intent intent = getIntent();
		Bundle paramConsulta = intent.getExtras();
		if(paramConsulta != null)
			cpf = paramConsulta.getString("cpf");

		progressDialog = ProgressDialog.show(ListaProjetosActivity.this, "Aguarde", "Processando...");
		
		Thread thread = new Thread(ListaProjetosActivity.this);
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
		ArrayList<Projeto> array = new ArrayList<Projeto>();
		if (projetos != null) {
			array.addAll(projetos);
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
	public List<Projeto> doInBackgroundTask(String... params) {
		List<Projeto> result = null;
		
		/*try {
			//result = bd.getAllMedicoesByDataAtual();
		result = null;
		} catch (GenericDAOException e) {
			adicionarEMostrarErro("Erro no banco de dados.");
		}*/
		
		return result;
	}

	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			progressDialog.dismiss();
			listaProjeto.setAdapter(adapterListView);
			

			if(cpf.length() < 11){
				//Toast.makeText(ListaProjetosActivity.this, "Cpf incompleto. Por favor preencha corretamente.", Toast.LENGTH_LONG).show();
				adicionarEMostrarErro("Cpf incompleto. Por favor preencha corretamente.");
				finish();
				
			} else if(listaProjeto.getCount() == 0){
			//	Toast.makeText(ListaProjetosActivity.this, "Nenhum projeto encontrado para este CPF.", Toast.LENGTH_LONG).show();
				
				adicionarEMostrarErro("Nenhum projeto encontrado para este CPF.");
				finish();
				
			} else if(listaProjeto.getCount() == 1){
				Toast.makeText(ListaProjetosActivity.this, listaProjeto.getCount() + " Projeto encontrado", Toast.LENGTH_LONG).show();	
			} else {
				Toast.makeText(ListaProjetosActivity.this, listaProjeto.getCount() + " Projetos encontrados", Toast.LENGTH_LONG).show();		
			}
		}
	};

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPostExecuteTask(List<Projeto> result) {
/*		ClientRest clienteRest = new ClientRest();
		SharedPreferences config = getSharedPreferences("config", MODE_PRIVATE);

		try {
			projetos = clienteRest.getListaMeusProjetos(config, cpf); //.getListaEditais(config);// .getListaMes();
			if (projetos != null && projetos.size() > 0) {
				ArrayList<ItemListViewEdital> listInfoEditais = new ArrayList<ItemListViewEdital>();
				
				for (Projeto projeto : projetos) {
					ItemListViewEdital itens = new ItemListViewEdital(projeto.getProjeto());
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
		handler.sendEmptyMessage(0);*/
  }

	@Override
	public void run() {
		ClientRest clienteRest = new ClientRest();
		SharedPreferences config = getSharedPreferences("config", MODE_PRIVATE);

		try {
			
			projetos = clienteRest.getListaMeusProjetos(config, cpf); //.getListaEditais(config);// .getListaMes();
			if (projetos != null && projetos.size() > 0) {
				ArrayList<ItemListViewProjeto> listInfoProjetos = new ArrayList<ItemListViewProjeto>();
				
				for (Projeto projeto : projetos) {
					ItemListViewProjeto itens = new ItemListViewProjeto(projeto.getProjeto());
					listInfoProjetos.add(itens);
				}
				adapterListView = new AdapterListViewProjeto(this, listInfoProjetos);
			} else {
				atualizarListaProjetos();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		handler.sendEmptyMessage(0);
	}
	protected void atualizarListaProjetos(){
		projetos = SplashActivity.sigepiMobileDatabase.listarProjetos();
		
		if (projetos != null && projetos.size() > 0) {
			ArrayList<ItemListViewProjeto> listInfoProjetos = new ArrayList<ItemListViewProjeto>();
			for (Projeto projeto : projetos) {
				ItemListViewProjeto itens = new ItemListViewProjeto(projeto.getProjeto());
				listInfoProjetos.add(itens);
			}
			adapterListView = new AdapterListViewProjeto(this, listInfoProjetos);
		} else {
			adicionarEMostrarErro("Não há projetos para serem exibidos.");
			finish();
		}
	}
}
