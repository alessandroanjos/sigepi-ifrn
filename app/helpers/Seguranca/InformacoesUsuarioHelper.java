package helpers.Seguranca;


import play.mvc.Controller;
import models.Usuario;


public class InformacoesUsuarioHelper extends Controller {

	public static Usuario getUsuarioLogado() {
		Long idUsuario = Long.parseLong(session("usuarioLogadoID"));
		
		return Usuario.find.byId(idUsuario);
	}

	public static Boolean isLogado() {
		return session().get("usuarioLogadoID") == null ? false : true;
	}
}
