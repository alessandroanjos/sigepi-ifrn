package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class Professores extends Controller{

	public static Result index(){
		return ok(views.html.Professor.index.render());
	}
	
	public static Result cadastrarProjeto(){
		return ok(views.html.Professor.cadastrarProjeto.render());
	}
	
	public static Result adicionarMembrosProjeto(){
		return ok(views.html.Professor.adicionarMembros.render());
	}
	public static Result exibirDadosCadastrados(){
		return TODO;
	}
}
