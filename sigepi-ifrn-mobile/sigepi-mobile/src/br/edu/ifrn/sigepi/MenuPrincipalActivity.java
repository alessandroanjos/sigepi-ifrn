package br.edu.ifrn.sigepi;

import br.edu.ifrn.sigepi.adapter.MenuPrincipalAdapter;
import br.edu.ifrn.sigepi.util.Response;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class MenuPrincipalActivity extends AndroidGenericActivity<Response> {

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
		
		menus = getResources().getStringArray(R.array.itens_menu_principal);
		
		((TextView) findViewById(R.id.text_cabecalho)).setText("MENU PRINCIPAL");
		
		gv = (ListView) findViewById(R.id.list_menu);
		
		
			processarRequisicao();
		
		
		gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v,int position, long id) {
				String menu = (String) v.getTag();
				
				Intent intent;
				
				if (menu.equals(menus[0])){
					intent = new Intent(MenuPrincipalActivity.this, ListaEditalActivity.class);
					startActivity(intent);
				} else if (menu.equals(menus[1])){
					intent = new Intent(MenuPrincipalActivity.this, MenuProjetosActivity.class);
					startActivity(intent);
				} else if (menu.equals(menus[2])){
					mostrarDialogSincronizar();
				} else if (menu.equals(menus[3])){
					intent = new Intent(MenuPrincipalActivity.this, ConfigurarActivity.class);
					startActivity(intent);
				}

			}		
		});
		SharedPreferences pref = this.getSharedPreferences("config", Context.MODE_PRIVATE);
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putBoolean(getString(R.string.intent_extra_1), sinc);
	}
	
	private void mostrarDialogSincronizar(){
		
		String titulo= "Sincronizar";
		String mensagem = "Tem certeza que deseja sincronizar agora?";
		
		Builder b = new Builder(this);
		b.setTitle(titulo);
		b.setMessage(mensagem);
		b.setCancelable(true);
		b.setPositiveButton(getString(R.string.sim), new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {

				dialog.dismiss();
				SincronizacaoTask sincronizar = new SincronizacaoTask(MenuPrincipalActivity.this);
				sincronizar.execute();
			}
		});
		b.setNegativeButton(getString(R.string.nao), new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
		
		AlertDialog ad = b.create();
		ad.show();
	}

	@Override
	public Response doInBackgroundTask(String... params) {
		Response result = new Response();
		return result;
	}

	@Override
	public void onPostExecuteTask(Response result) {
		
		MenuPrincipalAdapter adapter = new MenuPrincipalAdapter(this, true);
		
		gv.setAdapter(adapter);
		
	}
	
	@Override
	public void onBackPressed() {
		AlertDialog ad = null;
		Builder builder = new Builder(this);
		builder.setTitle("Sair");
		builder.setMessage("Tem certeza que deseja sair da aplicação?");
		builder.setCancelable(false);
		builder.setPositiveButton(getString(R.string.sim), new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				//voltarParaTelaLogin();
				finish();
			}
		});
		builder.setNegativeButton(getString(R.string.nao), new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		ad = builder.create();
		ad.show();
	}
	
	protected void montarMensagem(String titulo, String msg){
		if (!mensagem.equals("")){
			mensagem = mensagem+"\n"+titulo+"\n"+msg;
		} else {
			mensagem = titulo+"\n"+msg;
		}
	}
	
	
	private class MenuTask extends AsyncTask<String, Void, Response>{

		private Context context;
		private ProgressDialog progress;
		private Response mResult;
		
		public MenuTask(Context context) {
			this.context = context;
		}
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			
			if (progress != null && progress.isShowing())
				progress.dismiss();
			
			progress = new ProgressDialog(context);
			progress.setTitle(getString(R.string.dialog_titulo));
			progress.setMessage(getString(R.string.dialog_mensagem));
			progress.setCancelable(true);
			progress.setOnCancelListener(new OnCancelListener() {
				
				@Override
				public void onCancel(DialogInterface dialog) {
					// TODO Auto-generated method stub
					if (MenuTask.this.getStatus().equals(AsyncTask.Status.RUNNING)){
						progress.dismiss();
						progress = null;
						MenuTask.this.cancel(true);
					}
				}
			});
			progress.show();
		}
		
		@Override
		protected void onPostExecute(Response result) {

			progress.dismiss();
			
			String msg = result.getMensagem();
			if (!mResult.getMensagem().equals("")){
				msg = msg+"\n- Motivos e Impossibilidades:\n"+mResult.getMensagem();
			}
			
			mostrarDialog("Recebimento de Dados",result.getMensagem());
			
		}

		@Override
		protected Response doInBackground(String... params) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	public class SincronizacaoTask extends AsyncTask<String, Void, Response>{

		private ProgressDialog progress;
        private Context context;
        private Response recebimento;
        private Response motivosR;
 
        public SincronizacaoTask(Context context) {
            this.context = context;
        }
		
		@Override
		protected void onPreExecute() {
			
			progress = new ProgressDialog(context);
			progress.setTitle("Sincronizando");
            progress.setMessage(getString(R.string.dialog_mensagem));
            progress.setCancelable(false);
			progress.setCanceledOnTouchOutside(false);
            progress.show();
            
		}

		@Override
		protected void onPostExecute(Response result) {

			progress.dismiss();

			StringBuilder sb = new StringBuilder();
			sb.append("Status Envio:").append("\n");
			sb.append(result.getMensagem()).append("\n");
			sb.append("Status Recebimento:").append("\n");
			sb.append(recebimento.getMensagem());
			
			if (!motivosR.getMensagem().equals("")){
				sb.append("\n").append("Motivos e Impossibilidades:").append("\n");
				sb.append(motivosR.getMensagem());
			}
			
			mostrarDialog("Sincroniza��o", sb.toString());
		}

		@Override
		protected Response doInBackground(String... params) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
}
