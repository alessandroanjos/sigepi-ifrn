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

public class ClientRest {

	//private String ip = "10.20.6.5:9000";
    //  private String ip = "127.0.0.1:9000";
	// private String ip = "192.168.43.5:9000";
      private String ip = "169.254.21.42:9000";

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
	public List<Edital> getListaEditais() throws Exception {
		String url = "http://" + ip + "/ws/client/json";
		System.out.println("Passei aq");
		Log.i("URL: ", url);

		
		String[] resposta = new WebServiceClient().get(url);
		List<Edital> listaEditais = new ArrayList<Edital>();

		Log.i("######", resposta[0]);
		Log.i("######", resposta[1]);

		if (resposta[0].equals("200")) {
		
			GsonBuilder gsonb = new GsonBuilder();
			Gson gson = gsonb.create();
			
			//Gson gson = new Gson();

			// resposta[1]
			String sJson = resposta[1].substring(12, resposta[1].length()-2);
			String novoSJson = "[\""+"editais"+"\":"+sJson+"]";
			
			System.out.println("Array de Json: "+novoSJson);
			
		//	String a = resposta[1].substring(0);
		//	String b = resposta[1].substring(10);
		//	String c = "[\""+"editais"+"\":{"+"}";
			 //String a = resposta[1].substring(12, resposta[1].length()-2);
			// String b = "{\""+"editais"+"\":"+ a +"}";

			// System.out.println(b);

			//JsonParser parser = new JsonParser();
					
			//JsonArray array = parser.parse(resposta[1]).getAsJsonArray();
			//JSONArray jo = new JSONArray(resposta[1]);
			JSONArray jo = new JSONArray(novoSJson);
		    System.out.println("Array Json: "+jo.toString());
		    
		    for(int i=0; i< jo.length(); i++){
		    	listaEditais.add(gson.fromJson(jo.toString(), Edital.class));	
		    	System.out.println("Lista de editais: "
						+ listaEditais.size());
		    
		    }
		    
/*			
		//	JSONArray mtUsers = jo.getJSONArray("editais");
			// Log.i("###", (String) ja.get(1));
			for (JsonParser jsonElement : mtUsers) {
				listaEditais.add(gson.fromJson(jsonElement, Edital.class));
				System.out.println("Lista de editais: "
						+ listaEditais.toString());
			}
*/
			return listaEditais;

		} else {
			throw new Exception(resposta[1]);
		}

	}
	
	
	
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
			JsonArray array = parser.parse(resposta[1]).getAsJsonArray();
			
			for (JsonElement jsonElement : array) {
				listaEditais.add(gson.fromJson(jsonElement, Edital.class));
			}
			
			return listaEditais;
		} else {
			throw new Exception(resposta[1]);
		}
	}

}
