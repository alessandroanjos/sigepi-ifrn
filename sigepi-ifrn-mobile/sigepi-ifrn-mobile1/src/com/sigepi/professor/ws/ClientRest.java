package com.sigepi.professor.ws;

import java.util.ArrayList;
import java.util.List;

import org.json.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sigepi.professor.ListarProjetoCampusActivity;
import com.sigepi.professor.modelo.Edital;
import com.sigepi.professor.modelo.Projeto;
import com.sigepi.professor.modelo.ProjetoAvaliar;
import com.sigepi.professor.modelo.ProjetoStatusCampus;


import android.util.Log;

public class ClientRest {

	 public static boolean cod500 = false;

	 //private String ip = "10.20.10.13:9000";
	 //  private String ip = "10.17.3.33:9000";
	 //private String ip = "10.20.6.5:9000";
	 //  private String ip = "127.0.0.1:9000";
	 //private String ip = "192.168.43.5:9000";
     // private String ip = "169.254.21.42:9000";
	// private String ip = "10.20.2.161:9000";
	 //private String ip = "10.18.1.177:9000";
	 //private String ip = "10.20.15.113:9000";
	// private String ip = "10.18.1.177:9000";
	 private String ip = "10.0.0.3:9000";

	public List<Edital> getListaEditais() throws Exception {
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
			
			for (JsonElement jsonElement : jsonArray) {
				Edital edital = new Edital();
				edital.setTitulo(jsonElement.getAsString());
				listaEditais.add(edital);
			}

			return listaEditais;

		} else {
			throw new Exception(resposta[1]);
		}
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

	public List<Projeto> getListaMeusProjetos(String cpf) throws Exception {
		
		String[] resposta = new WebServiceClient().get("http://" + ip + "/ws/client/json/professor/"+ cpf +"/meus-projetos");
		List<Projeto> listaProjetos = new ArrayList<Projeto>();
		
		Log.i("###### - Código", resposta[0]);
		Log.i("###### - Json", resposta[1]);

		if (resposta[0].equals("200")) {
						
			JsonParser parser = new JsonParser();
			JsonObject jsonObject = parser.parse(resposta[1]).getAsJsonObject();
			JsonArray jsonArray = jsonObject.getAsJsonArray("projetos");
			
			for (JsonElement jsonElement : jsonArray) {
				Projeto projeto = new Projeto();
				projeto.setProjeto(jsonElement.getAsString());
				listaProjetos.add(projeto);
			}
			
			return listaProjetos;
		} else {
			throw new Exception(resposta[1]);
		}
	}

	public List<ProjetoAvaliar> getListaProjetosParaAvaliar(String cpf) throws Exception {

		String[] resposta = new WebServiceClient().get("http://" + ip + "/ws/client/json/professor/"+ cpf +"/projetos-avaliar");
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

}
