package com.example.sigepi_mobile;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class ExibirAcoes extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exibir_acoes);
		
		Button btProjetosAvaliar = (Button) findViewById(R.id.btProjetosAvaliar);
		Button btEditaisAbertos = (Button) findViewById(R.id.btEditaisAbertos);
		
		
		btProjetosAvaliar.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent iniciarProjetosAvaliar = new Intent(ExibirAcoes.this, ProjetosParaAvaliarActivity.class);
				startActivity(iniciarProjetosAvaliar);
				
			}
		});
		
		btEditaisAbertos.setOnClickListener(new View.OnClickListener() {
			
			
			public void onClick(View v) {
				Intent iniciarEditaisAbertos = new Intent(ExibirAcoes.this, EditaisAbertosActivity.class);
				startActivity(iniciarEditaisAbertos);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_exibir_acoes, menu);
		return true;
	}

}
