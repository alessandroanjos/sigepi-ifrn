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
import br.edu.ifrn.sigepi.modelo.Projeto;
import br.edu.ifrn.sigepi.modelo.ProjetoAvaliar;
import br.edu.ifrn.sigepi.util.ListaMensagens;
import br.edu.ifrn.sigepi.ws.ClientRest;

/**
 * 
 * @author Alessandro
 *
 */
public class ListaProjetosAvaliarActivity extends AndroidGenericActivity<List<Projeto>> implements OnItemClickListener, Runnable{
	
	private ListView listaProjeto;
	private List<ProjetoAvaliar> projetosAvaliar;
	private ListaEditalAdapter adapter;
	private ProgressDialog progressDialog;
	private AdapterListView adapterListView;
	private ListaMensagens mensagens = new ListaMensagens();
	private String cpf;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_projetos);
		
		((TextView) findViewById(R.id.text_cabecalho)).setText(getString(R.string.label_lista_projetos_avaliar));
		
		listaProjeto = (ListView) findViewById(R.id.list);
		
		Intent intent = getIntent();
		Bundle paramConsulta = intent.getExtras();
		if(paramConsulta != null)
			cpf = paramConsulta.getString("cpf");

		progressDialog = ProgressDialog.show(ListaProjetosAvaliarActivity.this, "Aguarde", "Processando...");
		
		Thread thread = new Thread(ListaProjetosAvaliarActivity.this);
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
		ArrayList<ProjetoAvaliar> array = new ArrayList<ProjetoAvaliar>();
		if (projetosAvaliar != null) {
			array.addAll(projetosAvaliar);
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
			
			if(listaProjeto.getCount() == 0){
						
				adicionarEMostrarErro("Nenhum projeto foi encontrado para avaliar com este CPF.");
				finish();
				
			} else if(listaProjeto.getCount() == 1){
				Toast.makeText(ListaProjetosAvaliarActivity.this, listaProjeto.getCount() + " Projeto encontrado para avaliar", Toast.LENGTH_LONG).show();	
			} else {
				Toast.makeText(ListaProjetosAvaliarActivity.this, listaProjeto.getCount() + " Projetos encontrados para a sua avaliação", Toast.LENGTH_LONG).show();		
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
			projetosAvaliar = clienteRest.getListaProjetosParaAvaliar(config, cpf); //.getListaEditais(config);// .getListaMes();
			if (projetosAvaliar != null && projetosAvaliar.size() > 0) {
				ArrayList<ItemListViewEdital> listInfoEditais = new ArrayList<ItemListViewEdital>();
				
				for (ProjetoAvaliar projetoAvaliar : projetosAvaliar) {
					ItemListViewEdital itens = new ItemListViewEdital(projetoAvaliar.getProjetoAvaliar());
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
	}
}
