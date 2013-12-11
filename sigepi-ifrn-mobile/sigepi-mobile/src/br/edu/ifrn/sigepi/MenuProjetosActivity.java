package br.edu.ifrn.sigepi;

import br.edu.ifrn.sigepi.adapter.MenuProjetosAdapter;
import br.edu.ifrn.sigepi.util.Response;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class MenuProjetosActivity extends AndroidGenericActivity<Response> {

	private ListView gv;
	
	private String[] menus;
	private boolean sinc = false;
	private String mensagem = "";
	private Response mResult;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_principal);
		
		menus = getResources().getStringArray(R.array.itens_menu_projetos);
		
		((TextView) findViewById(R.id.text_cabecalho)).setText("MENU PROJETOS");
		
		gv = (ListView) findViewById(R.id.list_menu);
		
		
			processarRequisicao();
		
		
		gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v,int position, long id) {
				String menu = (String) v.getTag();
				
				Intent intent;
				
				if (menu.equals(menus[0])){
					intent = new Intent(MenuProjetosActivity.this, MeusProjetosActivity.class);
					startActivity(intent);
				} else if (menu.equals(menus[1])){
					intent = new Intent(MenuProjetosActivity.this, AvaliarProjetosActivity.class);
					startActivity(intent);
				}

			}		
		});
		
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putBoolean(getString(R.string.intent_extra_1), sinc);
	}
	

	@Override
	public Response doInBackgroundTask(String... params) {
		Response result = new Response();
		return result;
	}

	@Override
	public void onPostExecuteTask(Response result) {
		
		MenuProjetosAdapter adapter = new MenuProjetosAdapter(this, true);
		
		gv.setAdapter(adapter);
		
	}
	
	protected void montarMensagem(String titulo, String msg){
		if (!mensagem.equals("")){
			mensagem = mensagem+"\n"+titulo+"\n"+msg;
		} else {
			mensagem = titulo+"\n"+msg;
		}
	}
}
