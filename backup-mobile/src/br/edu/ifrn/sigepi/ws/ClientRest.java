package br.edu.ifrn.sigepi.ws;

import java.util.ArrayList;
import java.util.List;

import org.json.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import android.util.JsonWriter;
import android.util.Log;
import br.edu.ifrn.sigepi.modelo.Edital;
import br.edu.ifrn.sigepi.modelo.Projeto;

public class ClientRest {

	//private String ip = "10.20.6.5:9000";
    //  private String ip = "127.0.0.1:9000";
	// private String ip = "192.168.43.5:9000";
     private String ip = "10.20.9.57:9000";
	// private String ip = "10.20.12.3:9000";
	//private static String ip = "10.17.2.7:9000";
	//private String ip = "10.17.2.94:9000";


	/*
	 * public List<Edital> getListaEdital(String dataInicial, String dataFinal,
	 * int idClinica) throws Exception { String url = "http://" + ip +
	 * "/recepcao/service/buscarConsultaPerido/" + "?datainicio=" + dataInicial
	 * + "&datafim=" + dataFinal + "&idclinica=" + idClinica;
	 * 
	 * Log.i("URL: ", url);
	 * 
	 * String[] resposta = new WebServiceClient().get(url); List<Consulta>
	 * listaConsultas = new ArrayList<Consulta>();
	 * 
	 * if (resposta[0].equals("200")) { Gson gson = new Gson();
	 * 
	 * JsonParser parser = new JsonParser(); JsonArray array =
	 * parser.parse(resposta[1]).getAsJsonArray();
	 * 
	 * for (JsonElement jsonElement : array) {
	 * listaConsultas.add(gson.fromJson(jsonElement, Consulta.class)); }
	 * 
	 * return listaConsultas;
	 * 
	 * } else { throw new Exception(resposta[1]); }
	 * 
	 * }
	 */
	
	
	public List<Edital> getListaEditais1() throws Exception {
		String url = "http://" + ip + "/ws/client/json";
		
		Log.i("URL: ", url);
		
		
		String[] resposta = new WebServiceClient().get(url);
		List<Edital> listaEditais = new ArrayList<Edital>();

		Log.i("######Código", resposta[0]);
		Log.i("######Json", resposta[1]);
		
		
		if (resposta[0].equals("200")) {
			Gson gson = new Gson();
			
			JsonParser parser = new JsonParser();
			JsonObject jsonObject = parser.parse(resposta[1]).getAsJsonObject();
			JsonArray jsonArray = jsonObject.getAsJsonArray("editais");
			
			for (JsonElement element : jsonArray) {
				Edital edital = new Edital();
				edital.setTitulo(element.getAsString());
				listaEditais.add(edital);
			}
//			JsonArray array = parser.parse(resposta[1]).getAsJsonArray();
//			
//			for (JsonElement jsonElement : array) {
//				listaEditais.add(gson.fromJson(jsonElement, Edital.class));
//			}
			
			return listaEditais;
		} else {
			throw new Exception(resposta[1]);
		}
	}
	
	public List<Projeto> getListaProjetos() throws Exception {
		String url = "http://" + ip + "/ws/client/listaprojetos";
		
		Log.i("URL: ", url);
		
		
		String[] resposta = new WebServiceClient().get(url);
		List<Projeto> listaProjetos = new ArrayList<Projeto>();

		Log.i("######Código", resposta[0]);
		Log.i("######Json", resposta[1]);
		
		
		if (resposta[0].equals("200")) {
			Gson gson = new Gson();
			
			JsonParser parser = new JsonParser();
			JsonObject jsonObject = parser.parse(resposta[1]).getAsJsonObject();
			JsonArray jsonArray = jsonObject.getAsJsonArray("projetos");
			
			for (JsonElement element : jsonArray) {
				Projeto p = new Projeto();
				p.setNomeDoProjeto(element.getAsString());				
				listaProjetos.add(p);
			}
//			JsonArray array = parser.parse(resposta[1]).getAsJsonArray();
//			
//			for (JsonElement jsonElement : array) {
//				listaEditais.add(gson.fromJson(jsonElement, Edital.class));
//			}
			
			return listaProjetos;
		} else {
			throw new Exception(resposta[1]);
		}
	}

}
