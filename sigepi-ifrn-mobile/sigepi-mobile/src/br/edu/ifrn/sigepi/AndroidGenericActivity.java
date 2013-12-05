package br.edu.ifrn.sigepi;

import br.edu.ifrn.sigepi.interfaces.IAsyncTask;
import br.edu.ifrn.sigepi.util.ListaMensagens;
import br.edu.ifrn.sigepi.util.Mensagem;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public abstract class AndroidGenericActivity<T> extends Activity implements IAsyncTask<T> {

	private ProcessadorRequisicao processadorRequisicao;

	private Toast toast;
	
	private String mensagem;
	
	private boolean msgSucesso;
	
	protected ProgressDialog progress;
	
	private ListaMensagens mensagens;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	
		mensagens = new ListaMensagens();
		
	}
	
	protected void adicionarEMostrarErro(String mensagem) {
		adicionarErro(mensagem);
		mostrarMensagens();
	}

	protected void adicionarEMostrarSucesso(String mensagem) {
		adicionarSucesso(mensagem);
		mostrarMensagens();
	}
	
	protected void adicionarErro(String mensagem) {
		mensagens.addMensagemErro(new Mensagem(mensagem, true));
	}
	
	protected void adicionarSucesso(String mensagem) {
		mensagens.addMensagemSucesso(new Mensagem(mensagem, false));
	}

	protected void mostrarMensagens() {
		mostrarMensagens(Toast.LENGTH_LONG);
	}

	private void mostrarMensagens(int duracao) {
		LayoutInflater inflater = getLayoutInflater();
		View layout = null;

		layout = montarLayout(inflater);

		if (toast != null)
			toast.getView().setVisibility(View.GONE);
		else {
			toast = new Toast(getApplicationContext());
		}
		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast.setDuration(duracao);
		toast.setView(layout);

		toast.show();
	}
	
	private View montarLayout(LayoutInflater inflater) {
		View layout = null;

		if (mensagens.contemErros()) {
			layout = inflater.inflate(R.layout.mensagem, (ViewGroup) findViewById(R.id.toast_layout_root));

			ImageView image = (ImageView) layout.findViewById(R.id.image);
			image.setImageResource(R.drawable.error);
			TextView text = (TextView) layout.findViewById(R.id.text);
			text.setText(mensagens.getMensagensErro());
		} else if (mensagens.contemSucessos()){
			layout = inflater.inflate(R.layout.mensagem, (ViewGroup) findViewById(R.id.toast_layout_root));

			ImageView image = (ImageView) layout.findViewById(R.id.image);
			image.setImageResource(R.drawable.success);
			TextView text = (TextView) layout.findViewById(R.id.text);
			text.setText(mensagens.getMensagensSucesso());
		}

		return layout;
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case 0:
			AlertDialog dialog = null;
			Builder builder = new Builder(this);
			builder.setMessage("Tem certeza que deseja sair da aplicação?");
			builder.setCancelable(true);
			builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					kill();
					//voltarParaTelaLogin();
					//finish();
					
				}
			});
			builder.setNegativeButton("Não", null);
			dialog = builder.create();
			dialog.show();
			break;

		default:
			break;
		}
		return super.onMenuItemSelected(featureId, item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.add(0, 0, 0, "Sair");
		return super.onCreateOptionsMenu(menu);
		
	}
	
	protected void mostrarDialog(String titulo, String texto){
		
		AlertDialog ad = null;
		Builder builder = new Builder(this);
		builder.setTitle(titulo);
		builder.setMessage(texto);
		builder.setCancelable(true);
		builder.setNeutralButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
		
		ad = builder.create();
		ad.show();
	}
	
	protected void mostrarDialogCustomizado(String titulo, String texto, DialogInterface.OnClickListener click){
		
		AlertDialog ad = null;
		Builder builder = new Builder(this);
		builder.setTitle(titulo);
		builder.setMessage(texto);
		builder.setCancelable(true);
		builder.setNeutralButton(getString(R.string.ok), click);
		
		ad = builder.create();
		ad.show();
	}

	protected void processarRequisicao(final String... param) {
		processadorRequisicao = new ProcessadorRequisicao(this);
		processadorRequisicao.execute(param);
	}
	
	protected void voltarParaTelaLogin() {
		Intent intent = new Intent(getApplicationContext(), MainActivity.class);
		//Intent intent = new Intent(Intent.ACTION_MAIN);
		//intent.addCategory(Intent.CATEGORY_HOME);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
		/*
		Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

		startActivity(intent);
		*/
		//finish();
		
	}
	
	public void kill() {
		android.os.Process.killProcess(android.os.Process.myPid());
	}
	
	class ProcessadorRequisicao extends AsyncTask<String, Object, T>{

		private Context context;
		
		public ProcessadorRequisicao(Context context) {
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
			progress.setCancelable(false);
			progress.setCanceledOnTouchOutside(false);
			progress.setOnCancelListener(new OnCancelListener() {
				
				@Override
				public void onCancel(DialogInterface dialog) {
					// TODO Auto-generated method stub
					if (processadorRequisicao.getStatus().equals(AsyncTask.Status.RUNNING)){
						progress.dismiss();
						progress = null;
						processadorRequisicao.cancel(true);
					}
				}
			});
			progress.show();
		}

		@Override
		protected void onPostExecute(T result) {
			try {
				progress.dismiss();
			} catch (Exception e) {
				Log.e(getClass().getName(), "Error dimissing dialog");
			} finally {
				progress = null;
			}
			onPostExecuteTask(result);
		}


		@Override
		protected T doInBackground(String... params) {
			T result = null;
			
			result = doInBackgroundTask(params);
			
			return result;
		}
		
	}

}
