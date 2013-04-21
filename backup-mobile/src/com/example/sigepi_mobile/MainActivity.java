package com.example.sigepi_mobile;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DialerFilter;
import android.widget.EditText;

public class MainActivity extends Activity {
	private EditText textCPF;
	//private EditText textSenha;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textCPF = (EditText) findViewById(R.id.campTextCPF);
		//textSenha = (EditText) findViewById(R.id.campTextSenha);
		
		Button btEntrar = (Button) findViewById(R.id.btEntrar);
		Button btLimpar = (Button) findViewById(R.id.btLimpar);
		
		btEntrar.setOnClickListener(new View.OnClickListener() {
			
			
			public void onClick(View arg0) {
				
						Intent it = new Intent(MainActivity.this, ExibirAcoes.class);
						startActivity(it);
			}
		});
		
		btLimpar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String text = textCPF.getText().toString();
				if(text != null){
					textCPF.setText("");
				}
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
