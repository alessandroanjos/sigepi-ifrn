package controllers;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * Classe controladora das páginas de Sobre.
 * @author Alessandro
 *
 */

public class Sobre extends Controller{
	/**
	 * Chama o método oProjeto.
	 * @return
	 */
	public static Result index(){
		return Sobre.oProjeto();
	}
	
	/**
	 * Renderiza a página de manual.
	 * @return
	 */
		
	public static Result manual() {
		return ok(views.html.Sobre.manual.render());
	}
	
	/**
	 * renderiza a página de equipe do sigepi.
	 * @return
	 */
	
	public static Result equipeSigepi() {
		return ok(views.html.Sobre.equipeSigepi.render());
	}
	
	/**
	 * Renderiza a página da equipe da reitoria.
	 * @return
	 */
	public static Result equipeProReitoria() {
        return ok(views.html.Sobre.equipeReitoria.render());
	}
	
	
	/**
	 * Renderiza a página do projeto.
	 * @return
	 */
	public static Result oProjeto() {
		return ok(views.html.Sobre.oProjeto.render());
	}

}
