package br.edu.ifrn.sigepi.ws;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrn.sigepi.SplashActivity;
import br.edu.ifrn.sigepi.modelo.Edital;
import br.edu.ifrn.sigepi.modelo.Projeto;
import br.edu.ifrn.sigepi.modelo.ProjetoAvaliar;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import android.content.SharedPreferences;
import android.util.Log;

public class ClientRest {

	 public static boolean cod500 = false;
	 private String ip;
	
	 public ClientRest(){	
	 }

	public List<Edital> getListaEditais(SharedPreferences config) throws Exception {
		ip = config.getString("host", "").toString().trim();
		String url = "http://" + ip + "/ws/client/json/editais";
		
		Log.i("URL: ", url);
		
		String[] resposta = new WebServiceClient().get(url);
		List<Edital> listaEditais = new ArrayList<Edital>();

		Log.i("###### - Código", resposta[0]);
		Log.i("###### - Json", resposta[1]);

		if (resposta[0].equals("200")) {
			
			JsonParser parser = new JsonParser();
			JsonObject jsonObject = parser.parse(resposta[1]).getAsJsonObject();
			JsonArray jsonArray = jsonObject.getAsJsonArray("editais");
			
			List<Edital> eds = SplashActivity.sigepiMobileDatabase.listarEditais();
			int qnt= eds.size();
			int jv = jsonArray.size();
			
			if(qnt != jv ){
				int qntExcluidos = SplashActivity.sigepiMobileDatabase.deletarTodosEditais();
				Log.i("###### Editais Excluidos", String.valueOf(qntExcluidos));
			}
			
			for (JsonElement jsonElement : jsonArray) {
				Edital edital = new Edital();
				edital.setTitulo(jsonElement.getAsString());
				listaEditais.add(edital);
				
				if(edital!=SplashActivity.sigepiMobileDatabase.buscarEdital(edital.getTitulo())){
					SplashActivity.sigepiMobileDatabase.criaEdital(edital);
				}
			}

			return listaEditais;

		} else if(!resposta[0].equals("200")) {
			return listaEditais;
		} else {
			throw new Exception(resposta[1]);
		}
	}
	
	

	public List<Projeto> getListaMeusProjetos(SharedPreferences config, String cpf) throws Exception {
				
		ip = config.getString("host", "").toString().trim();
		String url = "http://" + ip + "/ws/client/json/professor/"+ cpf +"/meus-projetos";
		
		Log.i("URL: ", url);
		
		String[] resposta = new WebServiceClient().get(url);
		List<Projeto> listaProjetos = new ArrayList<Projeto>();
		
		Log.i("###### - Código", resposta[0]);
		Log.i("###### - Json", resposta[1]);

		if (resposta[0].equals("200")) {
						
			JsonParser parser = new JsonParser();
			JsonObject jsonObject = parser.parse(resposta[1]).getAsJsonObject();
			JsonArray jsonArray = jsonObject.getAsJsonArray("projetos");
			
			List<Projeto> projetosBancoLocal = SplashActivity.sigepiMobileDatabase.listarProjetos();
			int qnt= projetosBancoLocal.size();
			int jv = jsonArray.size();
			
			if(qnt != jv ){
				int qntExcluidos = SplashActivity.sigepiMobileDatabase.deletarTodosProjetos();
				Log.i("###### Projetos Excluidos", String.valueOf(qntExcluidos));
			}
			
			for (JsonElement jsonElement : jsonArray) {
				Projeto projeto = new Projeto();
				projeto.setProjeto(jsonElement.getAsString());
				listaProjetos.add(projeto);
				
				if(projeto!=SplashActivity.sigepiMobileDatabase.buscarProjeto(projeto.getProjeto())){
					SplashActivity.sigepiMobileDatabase.criaProjeto(projeto);
				}
			}
			
			return listaProjetos;
			
		} else if(!resposta[0].equals("200")) {
				return listaProjetos;
		} else {
			throw new Exception(resposta[1]);
		}
	}

	public List<ProjetoAvaliar> getListaProjetosParaAvaliar(SharedPreferences config, String cpf) throws Exception {
		
		ip = config.getString("host", "").toString().trim();
		String url = "http://" + ip + "/ws/client/json/professor/"+ cpf +"/projetos-avaliar-cpf";
		
		Log.i("URL: ", url);

		String[] resposta = new WebServiceClient().get(url);
		List<ProjetoAvaliar> listaProjetos = new ArrayList<ProjetoAvaliar>();
		
		Log.i("###### - Código", resposta[0]);
		Log.i("###### - Json", resposta[1]);

		if (resposta[0].equals("200")) {
						
			JsonParser parser = new JsonParser();
			JsonObject jsonObject = parser.parse(resposta[1]).getAsJsonObject();
			JsonArray jsonArray = jsonObject.getAsJsonArray("projetos");
			
			for (JsonElement jsonElement : jsonArray) {
				ProjetoAvaliar projeto = new ProjetoAvaliar();
				projeto.setProjetoAvaliar(jsonElement.getAsString());
				listaProjetos.add(projeto);
			}
			
			return listaProjetos;
		} else {
			throw new Exception(resposta[1]);
		}
	}

	/*
	public List<ProjetoStatusCampus> getStatusProjetosCampus(String cpf) throws Exception {
		String[] resposta = new WebServiceClient().get("http://" + ip
				+ "/ws/client/json/campus/coordenador/" + cpf + "/projetos");
		List<ProjetoStatusCampus> listaProjetos = new ArrayList<ProjetoStatusCampus>();

		Log.i("###### - Código", resposta[0]);
		Log.i("###### - Json", resposta[1]);

		if (resposta[0].equals("500")) {
			cod500 = true;
		} else {

			if (resposta[0].equals("200")) {

				JsonParser parser = new JsonParser();
				JsonObject jsonObject = parser.parse(resposta[1]).getAsJsonObject();
				JsonArray jsonArray = jsonObject.getAsJsonArray("projetos");

				for (JsonElement jsonElement : jsonArray) {
					ProjetoStatusCampus projeto = new ProjetoStatusCampus();
					projeto.setProjetoStatusCampus(jsonElement.getAsString());
					listaProjetos.add(projeto);
				}

				return listaProjetos;
			} else {
				throw new Exception(resposta[1]);
			}

		}
		return listaProjetos;
	}
	
	public List<Edital> getListaEditais2() throws Exception {
		String url = "http://" + ip + "/editais";
		Log.i("URL: ", url);
		String[] resposta = new WebServiceClient().get(url);
		List<Edital> listaEditais = new ArrayList<Edital>();

		Log.i("###### - Código", resposta[0]);
		Log.i("###### - Json", resposta[1]);

		if (resposta[0].equals("200")) {

			Gson gson = new Gson();

			JsonParser parser = new JsonParser();
			
			JsonArray jsonArray = parser.parse(resposta[1]).getAsJsonArray();

			for (JsonElement jsonElement : jsonArray) {
				listaEditais.add(gson.fromJson(jsonElement, Edital.class));
			}

			return listaEditais;

		} else {
			throw new Exception(resposta[1]);
		}
	}
	
	*
	*
	*/

}
