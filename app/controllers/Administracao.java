package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class Administracao extends Controller {

	public static Result index(){
        return ok(views.html.Administrador.index.render());
	}
	
	public static Result cadastrarEdital(){
		return ok(views.html.Administrador.cadastrarEdital.render());
	}
	
	public static Result gerenciarBolsista(){
		return ok(views.html.Administrador.gerenciarBolsista.render());
	}
}
