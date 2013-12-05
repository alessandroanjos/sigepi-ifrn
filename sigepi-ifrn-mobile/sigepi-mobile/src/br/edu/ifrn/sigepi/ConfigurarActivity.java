package br.edu.ifrn.sigepi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConfigurarActivity extends AndroidGenericActivity<Boolean>{

	private int pos = 0;
	private SharedPreferences pref;
	private String opcao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.configurar);
		
		pref = this.getSharedPreferences("config", Context.MODE_PRIVATE);
		
		((TextView) findViewById(R.id.text_cabecalho)).setText(getString(R.string.label_configurar));
		
		final EditText host = (EditText) findViewById(R.id.et_host);
				
		host.setText(pref.getString("host", ""));
		
		Button salvar = (Button) findViewById(R.id.bt_configurar);
		salvar.setClickable(true);
		salvar.setEnabled(true);
		salvar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				v.setClickable(false);
				v.setEnabled(false);
				String msg = "";
								
				String h = host.getText().toString().trim();
				
				if (h.equals("")){
					if (msg.equals(""))
						adicionarEMostrarErro("É necessário preencher o campo host para salvar as configurações.");
					else 
						adicionarEMostrarErro("É necessário preencher o campo host para salvar as configurações.");
				} else {
					pref.edit().putString("host", host.getText().toString()).commit();
					
					//opcao = pref.getInt("frequencia", 0) == 0 ? "Manual":op[pref.getInt("frequencia", 0)];
					//adicionarEMostrarSucesso("Host: "+pref.getString("host","")+"\n"+"Op��o: "+opcao);
					processarRequisicao();
				}
			}
		});
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}

	@Override
	public void onPostExecuteTask(Boolean result) {
		// TODO Auto-generated method stub

		// iniciarServicoSincronia(getResources().getIntArray(R.array.frequencia_tempo)[pos]);
		mostrarDialogCustomizado("Configurações",
				"Host: " + pref.getString("host", ""), new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
						ConfigurarActivity.this.finish();
			}
		});
	}

	@Override
	public Boolean doInBackgroundTask(String... params) {
		// TODO Auto-generated method stub
		//((SGMAndroidApplication) getApplication()).getHessianChannel().configurar();
		//return pararServicoSincronizar();
		return false;
	}

}
