package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class Avaliadores extends Controller{

	public static Result index(){
		return ok(views.html.Avaliador.index.render());
	}
	
	public static Result avaliarProjeto(){
		return ok(views.html.Avaliador.avaliarProjeto.render());
	}
	
	public static Result acessarDadosProjeto(){
		return ok(views.html.Avaliador.acessarDadosProjeto.render());
	}
	
	public static Result acessarFormulario(){
		return ok(views.html.Avaliador.formularioAvaliacao.render());
	}
}
