package com.sigepi.professor;

import com.sigepi.professor.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
       /* super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);		
		
		Button btConsultarEditais = (Button) findViewById(R.id.btEditais);
				
        btConsultarEditais.setOnClickListener(new View.OnClickListener() {
			
        	public void onClick(View arg0) {
				
				Intent it = new Intent(MainActivity.this, ListarEditaisActivity.class);
				startActivity(it);
				
				AlertDialog.Builder sucesso = new AlertDialog.Builder(MainActivity.this);
				sucesso.setMessage("Consultando Editais!");
				sucesso.show();
			}
		});*/
        
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btEditais = (Button) findViewById(R.id.btEditais);
        btEditais.setOnClickListener(btEditaisOnClickListener);
        
        Button btHistoricoEditais = (Button) findViewById(R.id.btEditaisSalvos);
        btHistoricoEditais.setOnClickListener(btHistoricoOnClickListener);
        
        Button btProjetos = (Button) findViewById(R.id.btProjetos);
        btProjetos.setOnClickListener(btProjetosOnClickListener);
        
        Button btAvaliar = (Button) findViewById(R.id.btAvaliar);
        btAvaliar.setOnClickListener(btAvaliarOnClickListener);
        
        Button btStatus = (Button) findViewById(R.id.btStatus);
        btStatus.setOnClickListener(btStatusOnClickListener);
        
        Button btHistoricoProjetos = (Button) findViewById(R.id.btProjetosSalvos);
        btHistoricoProjetos.setOnClickListener(btProjetosSalvosOnClickListener);
        
        
        
        
        
        /* ImageButton btEditais = (ImageButton) findViewById(R.id.btEditais);
        btEditais.setOnClickListener(btEditaisOnClickListener);
        
        ImageButton btHistoricoEditais = (ImageButton) findViewById(R.id.btEditaisSalvos);
        btHistoricoEditais.setOnClickListener(btHistoricoOnClickListener);
        
        ImageButton btProjetos = (ImageButton) findViewById(R.id.btProjetos);
        btProjetos.setOnClickListener(btProjetosOnClickListener);
        
        ImageButton btAvaliar = (ImageButton) findViewById(R.id.btAvaliar);
        btAvaliar.setOnClickListener(btAvaliarOnClickListener);
        
        ImageButton btStatus = (ImageButton) findViewById(R.id.btStatus);
        btStatus.setOnClickListener(btStatusOnClickListener);
        
        ImageButton btHistoricoProjetos = (ImageButton) findViewById(R.id.btProjetosSalvos);
        btHistoricoProjetos.setOnClickListener(btProjetosSalvosOnClickListener);*/
        
    }
    
    private OnClickListener btEditaisOnClickListener = new OnClickListener() {
        public void onClick(View v) {
        	Intent it = new Intent(MainActivity.this, ListarEditaisActivity.class);
			startActivity(it);
        }
    };
    
    private OnClickListener btHistoricoOnClickListener = new OnClickListener() {
        public void onClick(View v) {
        	Intent it = new Intent(MainActivity.this, ListarHistoricoEditaisActivity.class);
			startActivity(it);
        }
    };
    
    private OnClickListener btProjetosOnClickListener = new OnClickListener() {
        public void onClick(View v) {
        	Intent it = new Intent(MainActivity.this, BuscarProjetoCpfActivity.class);
			startActivity(it);
        }
    };
    
    private OnClickListener btAvaliarOnClickListener = new OnClickListener() {
        public void onClick(View v) {
        	Intent it = new Intent(MainActivity.this, BuscarProjetosAvaliarCpfActivity.class);
			startActivity(it);
        }
    };
    
    private OnClickListener btStatusOnClickListener = new OnClickListener() {
        public void onClick(View v) {
        	Intent it = new Intent(MainActivity.this, BuscarProjetosCampusCpfActivity.class);
			startActivity(it);
        }
    };
    
    private OnClickListener btProjetosSalvosOnClickListener = new OnClickListener() {
        public void onClick(View v) {
        	Intent it = new Intent(MainActivity.this, ListarHistoricoProjetosActivity.class);
			startActivity(it);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
