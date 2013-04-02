package com.example.sigepi_mobile;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class ProjetosParaAvaliarActivity extends Activity {
	public ListView listarProjetos;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_projetos_para_avaliar);
		//ArrayAdapter é usado para carregar os dados de um ListView
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, projetos);
		listarProjetos = (ListView) findViewById(R.id.IsProjetos);
		listarProjetos.setAdapter(adapter);
		
		listarProjetos.setOnItemClickListener(new OnItemClickListener() {

			
			public void onItemClick(AdapterView arg0, View arg1, int arg2,
					long arg3) {
				if(listarProjetos.getSelectedItem() != null){
					AlertDialog.Builder dialogo = new AlertDialog.Builder(ProjetosParaAvaliarActivity.this);
					dialogo.setTitle("Você tem 5 dias para avaliar");
					dialogo.setMessage(listarProjetos.getSelectedItem().toString());
					dialogo.setNeutralButton("Ok", null);
					dialogo.show();
				}
			}
		});
	
	}
	static final String[] projetos = new String[]{
		"Potigol", "Epol", "Lais", "Sigepi"
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_projetos_para_avaliar, menu);
		return true;
	}

}
