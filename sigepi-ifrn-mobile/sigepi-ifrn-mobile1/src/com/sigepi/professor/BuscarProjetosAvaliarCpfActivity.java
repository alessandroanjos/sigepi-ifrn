package com.sigepi.professor;

import com.sigepi.professor.modelo.Projeto;
import com.sigepi.professor.modelo.ProjetoAvaliar;
import com.sigepi.professor.ws.ClientRest;

import android.annotation.SuppressLint;
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

@SuppressLint("HandlerLeak")
public class BuscarProjetosAvaliarCpfActivity extends Activity {

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
		setContentView(R.layout.buscar_por_cpf);

		cpfBusca = (EditText) findViewById(R.id.buscarCpf);
		btBuscar = (Button) findViewById(R.id.btBuscar);
		isCheckSalvarConsulta = (CheckBox) findViewById(R.id.checkBoxSalvar);

		carregarCampos();

		Intent intent = getIntent();

		// verifica se esta recebendo parametros de outra tala,
		// no caso para exibir detalhes da consulta selecionada
		paramConsulta = intent.getExtras();
		if (paramConsulta != null) {
			ProjetoAvaliar consultaAtual = montarObjetoConsulta(paramConsulta);
			preencherCampos(consultaAtual);
		}

		btBuscar.setOnClickListener(btBuscarOnClickListener);
		//btEditar.setOnClickListener(btEditarOnClickListener);
	}

	private OnClickListener btBuscarOnClickListener = new OnClickListener() {
		public void onClick(View v) {
			if (!cpfBusca.getText().toString().equals("")) {
				Intent it = new Intent(BuscarProjetosAvaliarCpfActivity.this,
						ListarProjetosAvaliarActivity.class);
				Bundle parametros = new Bundle();
				parametros.putString("cpf", cpfBusca.getText().toString());
				it.putExtras(parametros);
				startActivity(it);
			} else {
				Toast.makeText(getApplicationContext(), "Digite seu CPF",
						Toast.LENGTH_SHORT).show();
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
				Toast.makeText(BuscarProjetoCpfActivity.this,
						"Consulta confirmada.", Toast.LENGTH_LONG).show();

				break;
			case R.id.statusCancelado:
				status = 4;
				Toast.makeText(BuscarProjetoCpfActivity.this,
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
	*/

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
	
	
	private ProjetoAvaliar montarObjetoConsulta(Bundle param) {
		ProjetoAvaliar projeto = new ProjetoAvaliar();

		projeto.setId(param.getInt(ProjetoAvaliar.ID)); // id da consulta no banco local
		projeto.setProjetoAvaliar(param.getString(ProjetoAvaliar.PROJETO_AVALIAR));

		return projeto;
	}

	
	
	private void preencherCampos(ProjetoAvaliar p) {
		layoutInformacoes.setVisibility(View.VISIBLE);
		layoutBusca.setVisibility(View.GONE);
		isCheckSalvarConsulta.setVisibility(View.VISIBLE);

		idAtual = p.getId();

		exibirNome.setText(p.getProjetoAvaliar());
	}
	

}
