package br.edu.ifrn.sigepi;

import br.edu.ifrn.sigepi.modelo.Projeto;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MeusProjetosActivity extends Activity {

	private TextView exibirNome, exibirData, exibirHora, exibirClinica,
			exibirStatus;
	private LinearLayout layoutInformacoes, layoutBusca;
	private Button btBuscar, btEditar;
	private EditText cpfBusca;
	private RadioGroup tipoStatus;
	private CheckBox isCheckSalvarConsulta;
	private Bundle paramConsulta;
	private int idAtual = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.buscar_projetos_cpf);
		
		((TextView) findViewById(R.id.text_cabecalho)).setText(getString(R.string.label_buscar_projetos));

		cpfBusca = (EditText) findViewById(R.id.et_cpf);
		btBuscar = (Button) findViewById(R.id.bt_buscar_projetos);
		
		//carregarCampos();

		Intent intent = getIntent();

		// verifica se esta recebendo parametros de outra tala,
		// no caso para exibir detalhes da consulta selecionada
		paramConsulta = intent.getExtras();
		if (paramConsulta != null) {
			Projeto consultaAtual = montarObjetoConsulta(paramConsulta);
			preencherCampos(consultaAtual);
		}

		btBuscar.setOnClickListener(btBuscarOnClickListener);
		//btEditar.setOnClickListener(btEditarOnClickListener);
	}

	private OnClickListener btBuscarOnClickListener = new OnClickListener() {
		public void onClick(View v) {
			if (!cpfBusca.getText().toString().equals("")) {
				Intent it = new Intent(MeusProjetosActivity.this,
						ListaProjetosActivity.class);
				Bundle parametros = new Bundle();
				parametros.putString("cpf", cpfBusca.getText().toString());
				it.putExtras(parametros);
				startActivity(it);
			} else {
				Toast.makeText(getApplicationContext(), "Digite o seu CPF",	Toast.LENGTH_SHORT).show();
			}
		}
	};

/*	
	private OnClickListener btEditarOnClickListener = new OnClickListener() {
		public void onClick(View v) {
			int status = -1;

			switch (tipoStatus.getCheckedRadioButtonId()) {
			case R.id.statusConfirmado:
				status = 2;
				Toast.makeText(MeusProjetosActivity.this,
						"Consulta confirmada.", Toast.LENGTH_LONG).show();

				break;
			case R.id.statusCancelado:
				status = 4;
				Toast.makeText(MeusProjetosActivity.this,
						"Consulta cancelada.", Toast.LENGTH_LONG).show();
				break;
			}

			try {
				ClientRest clienteRest = new ClientRest();
				clienteRest.confirmarConsulta(idAtual, status);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				Intent intent = new Intent(BuscarConsultaCpfActivity.this,
						MainActivity.class);
				startActivity(intent);
			}
		}
	};
	

	
	private void carregarCampos() {
		
		layoutInformacoes = (LinearLayout) findViewById(R.id.layoutInformacoes);
		layoutBusca = (LinearLayout) findViewById(R.id.layoutBusca);
		exibirNome = (TextView) findViewById(R.id.exibiNome);
		exibirData = (TextView) findViewById(R.id.exibirData);
		exibirHora = (TextView) findViewById(R.id.exibirHora);
		exibirClinica = (TextView) findViewById(R.id.exibirClinica);
		exibirStatus = (TextView) findViewById(R.id.exibirStatus);
		tipoStatus = (RadioGroup) findViewById(R.id.tipoStatus);
		btEditar = (Button) findViewById(R.id.btEdita);
	}
	
	

	*/
	
	private void preencherCampos(Projeto c) {
		layoutInformacoes.setVisibility(View.VISIBLE);
		layoutBusca.setVisibility(View.GONE);
		isCheckSalvarConsulta.setVisibility(View.VISIBLE);

		idAtual = c.getId();

		exibirNome.setText(c.getProjeto());
	}
	
	private Projeto montarObjetoConsulta(Bundle param) {
		Projeto consulta = new Projeto();

		consulta.setId(param.getInt(Projeto.ID)); // id da consulta no banco local
	
		consulta.setProjeto(param.getString(Projeto.PROJETO));
		
		return consulta;
	}


}
