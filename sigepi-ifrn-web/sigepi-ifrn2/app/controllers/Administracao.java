package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class Administracao extends Controller{

	/**
     * Area de incio do Administrador
     */
	@helpers.Seguranca.Permissao("Administrador")
	public static Result index(){
        return ok(views.html.Administrador.index.render());
	}
}
