package ws;

import helpers.Seguranca.InformacoesUsuarioHelper;

import java.awt.image.renderable.RenderableImage;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import play.mvc.Controller;
import models.Edital;
import models.Projeto;
import models.Usuario;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.ObjectNode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.reflections.serializers.JsonSerializer;

import controllers.Editais;

//import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import play.libs.F.Promise;
import play.libs.Json;
import play.libs.WS;
import play.libs.WS.Response;
import play.libs.WS.WSRequestHolder;
import play.mvc.Controller;
import play.mvc.Result;

public class Servico extends Controller {

	// https://api.github.com/events
	final private static String url = "";

	public static Result getXmlResponse() {
		return badRequest("Not yet implemented");
	}

	public static Result getJsonResponse() {
		WSRequestHolder service = WS.url(url);
		Promise<Response> promise = service.get();
		Response response = promise.get();
		JsonNode json = response.asJson();

		ObjectNode info = Json.newObject();
		info.put("url", url);
		// info.
		info.put("size", json.size());

		ObjectNode result = Json.newObject();
		result.put("message", "OK");
		result.put("info", info);

		// result.putPOJO("teste", new Pessoa());
		return ok(result);
	}

	public static Result getListaEditais() {
		List<Edital> editais = Edital.find.findList();

		List<String> lista = new ArrayList<String>();

		ObjectNode result = Json.newObject();

		for (Edital e : editais) {
			// result.put("edital",e.getTitulo());
			// lista.add(Json.toJson(e.getTitulo()).toString());
			lista.add(e.getTitulo());
		}

		JSONArray jsArray = new JSONArray(lista);
		result.putPOJO("editais", jsArray.toString());

		return ok(result);
	}


	// webservice de teste
	public static Result ola() {
		ObjectNode resultado = Json.newObject();
		resultado.put("id", 1);
		resultado.put("msgText", "Ola, funcionou :D");
		return ok(resultado);
	}
	
	public static Result getListaProjetos(){
		List<Projeto> projetos = Projeto.find.findList();

		  ArrayList<String> lista = new ArrayList<String>();
		  
		  ObjectNode result = Json.newObject();

		  for (Projeto p : projetos) {
			  lista.add(p.getTitulo());
		  }

			JSONArray jsArray = new JSONArray(lista);
		  result.putPOJO("projetos", jsArray.toString());
		  
		  return ok(result);
	
	}

	public static Result getListarProjetos() {
		List<Projeto> projetos = Projeto.find.findList();

		ArrayList<String> lista = new ArrayList<String>();
		WSRequestHolder service = WS.url(url);
		Promise<Response> promise = service.get();
		Response response = promise.get();
		JsonNode json = response.asJson();

		ObjectNode info = Json.newObject();
		info.put("url", url);
		info.put("size", json.size());

		ObjectNode result = Json.newObject();
		result.put("message", "OK");
		result.put("info", info);

		for (Projeto e : projetos) {
			// result.put("edital",e.getTitulo());
			lista.add(Json.toJson(e.getTitulo()).toString());
		}

		result.putPOJO("projetos", lista);

		/*
		 * ("projetos", projetos.listIterator().next().titulo);
		 * result.POJONode(projetos.get(1).titulo); result.putPOJO("projetos:",
		 * Projeto.find.findList().get());
		 */
		return ok(result);
	}

	public static Result getListaProjetosParaAvaliar(Long id) {
		
		List<Projeto> projetos = Projeto.find.where().eq("usuario_avaliar", id).findList();
		
		ArrayList<String> lista = new ArrayList<String>();
		  
		  ObjectNode result = Json.newObject();

		  for (Projeto p : projetos) {
			  lista.add(p.getTitulo());
		  }

		  JSONArray jsArray = new JSONArray(lista);
		  result.putPOJO("projetos", jsArray.toString());
		  
		  return ok(result);
	}
	
	
	public static Result getListaMeusProjetos(Long id){
		
		List<Projeto> projetos = Projeto.find.where().eq("autor_id", id).findList();

		  ArrayList<String> lista = new ArrayList<String>();
		  
		  ObjectNode result = Json.newObject();

		  for (Projeto p : projetos) {
			  lista.add(p.getTitulo());
		  }

		  JSONArray jsArray = new JSONArray(lista);
		  result.putPOJO("projetos", jsArray.toString());
		  
		  return ok(result);
	
	}
	
	public static Result getMeuProjetoSituacao(Long id) {

		List<Projeto> projetos = Projeto.find.where().eq("id", id).findList();
		ObjectNode result = Json.newObject();

		for (Projeto p : projetos) {
			// result.put("projeto", String.valueOf(p.getSituacao()));
			if (p.getSituacao() == 1) {
				result.put("projeto", "Aprovado");
			} else if (p.getSituacao() == 0) {
				result.put("projeto", "Reprovado");
			} else {
				result.put("projeto", "Em Avaliação");
			}
		}

		return ok(result);
	}
	
}
