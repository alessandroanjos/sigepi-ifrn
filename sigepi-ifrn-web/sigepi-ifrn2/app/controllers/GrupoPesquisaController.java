package controllers;

import helpers.Seguranca.InformacoesUsuarioHelper;
import helpers.Seguranca.Permissao;

import java.util.Date;
import java.util.List;

import models.Campus;
import models.GrupoPesquisa;
import models.Edital;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class GrupoPesquisaController extends Controller {

	public static Result index(){		
			
			List<GrupoPesquisa> gruposPesquisa = GrupoPesquisa.find.findList();
			
			return ok(views.html.GrupoPesquisa.index.render(gruposPesquisa));
		}

	public static Result visualizar(Long id){
			
			GrupoPesquisa gruposPesquisa= GrupoPesquisa.find.byId(id);
			
			return ok(views.html.GrupoPesquisa.visualizar.render(gruposPesquisa));
		}



} //final
