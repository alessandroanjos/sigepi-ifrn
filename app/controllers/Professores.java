package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class Professores extends Controller{

	public static Result index(){
		return ok(views.html.Professor.index.render());
	}
	
	public static Result criarNovoProjeto(){
		return ok(views.html.Professor.criarNovoProjeto.render());
	}
	
	public static Result adicionarMembrosProjeto(){
		return ok(views.html.Professor.adicionarMembros.render());
	}
	public static Result exibirDadosCadastrados(){
		return ok(views.html.Professor.resumoCadastroProjeto.render());
	}
	
	public static Result atualizarCurriculo(){
	    return ok(views.html.Professor.atualizarCurriculo.render());
	}
	
	public static Result visualizarCurriculo(){
		return ok(views.html.Professor.visualizarCurriculo.render());
	}
}
