package controllers;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * Classe controladora do Administrador.
 *
 * @author Alessandro
 *
 */
public class Administracao extends Controller{

	/**
	 * Retorna a área de início do Administrador.
	 *
	 * @return
	 */
	@helpers.Seguranca.Permissao("Administrador")
	public static Result index(){
        return ok(views.html.Administrador.index.render());
	}
}
