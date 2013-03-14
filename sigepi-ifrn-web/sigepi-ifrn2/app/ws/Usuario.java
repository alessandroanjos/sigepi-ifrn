package ws;

import java.util.List;

import org.codehaus.jackson.JsonNode;

import models.Edital;
import play.api.libs.ws.WS;
import play.api.libs.ws.WS.WSRequestHolder;
import play.libs.WS.Response;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

public class Usuario extends Controller {

	static final String url = "www";
	@BodyParser.Of(BodyParser.Json.class)
	public static Result autenticacao(String login, String senha) {

		return ok();
	//	return ok(arg0, "json"));
	}

	/*
	 * public static void index(){ List<Edital> editais =
	 * Edital.find.findList();
	 * 
	 * renderJSON(editais); }
	 */
	public static Result sayHello(Long id) {
        Edital edital = Edital.find.byId(id);
		
		return ok(views.html.Editais.visualizar.render(edital));
	}/*
	
	public static Result get(){
		WSRequestHolder service = WS.url(url);
		Promise<WS.Response> promisse = aervice.get();
		Response response = promisse.getClass();
	}
	*/
}
