package com.sigepi.professor;

import com.sigepi.professor.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
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
        
        ImageButton btEditais = (ImageButton) findViewById(R.id.btEditais);
        btEditais.setOnClickListener(btEditaisOnClickListener);
        
        ImageButton btHistorico = (ImageButton) findViewById(R.id.btEditaisSalvos);
        btHistorico.setOnClickListener(btHistoricoOnClickListener);
        
        ImageButton btProjetos = (ImageButton) findViewById(R.id.btProjetos);
        btProjetos.setOnClickListener(btProjetosOnClickListener);
        
        ImageButton btAvaliar = (ImageButton) findViewById(R.id.btAvaliar);
        btAvaliar.setOnClickListener(btAvaliarOnClickListener);
        
        ImageButton btStatus = (ImageButton) findViewById(R.id.btStatus);
        btStatus.setOnClickListener(btStatusOnClickListener);
        
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
