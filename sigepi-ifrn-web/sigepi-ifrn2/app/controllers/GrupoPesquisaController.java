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

	//Result
	public static Result index(){		
			
			List<GrupoPesquisa> gruposPesquisa = GrupoPesquisa.find.findList();
			
			return ok(views.html.GrupoPesquisa.index.render(gruposPesquisa));
		}

	//Visualizar
	public static Result visualizar(Long id){
			
			GrupoPesquisa gruposPesquisa= GrupoPesquisa.find.byId(id);
			
			return ok(views.html.GrupoPesquisa.visualizar.render(gruposPesquisa));
		}

	// Permissão para Administrador
	@Permissao("Administrador")
	public static Result formulario() {
		return ok(views.html.GrupoPesquisa.formulario.render(form(GrupoPesquisa.class)));
	}

	//Cadastrar
	@Permissao("Administrador")
	public static Result cadastrar(){
		
		Form<GrupoPesquisa> form = form(GrupoPesquisa.class).bindFromRequest();
		
		if(form.hasErrors()){
			flash().put("error", "Você deve preencher o campo corretamente. Tente novamente!");
			return badRequest(views.html.GrupoPesquisa.formulario.render(form));
		}
		
		GrupoPesquisa grupos = form.get();
		/*campus.autor = InformacoesUsuarioHelper.getUsuarioLogado();*/				
		grupos.save();
		
		flash().put("success", "Campus \""+grupos.nome +"\" Cadastrado com Sucesso!");
		
		return redirect(routes.GrupoPesquisaController.index());
	}
	
		// Editar
		public static Result editar(Long id) {
		
		Form<GrupoPesquisa> form = form(GrupoPesquisa.class).bindFromRequest();
		GrupoPesquisa grupos = GrupoPesquisa.find.byId(id);
		
		if(form.hasErrors()) {
			flash().put("error", "Você deve preencher todos os campos corretamente. Tente novamente!");
			return badRequest(views.html.GrupoPesquisa.formularioEdicao.render(form.fill(form.get()), grupos));
		}
		
		grupos.setNome(form.get().nome);
		grupos.update();
		
		flash().put("success", "Grupo de Pesquisa\""+ grupos.nome +"\" atualizado com sucesso!");
		return redirect(routes.GrupoPesquisaController.index());
	}

		
		public static Result formularioEdicao(Long id) {
		GrupoPesquisa grupos = GrupoPesquisa.find.byId(id);
		return ok(views.html.GrupoPesquisa.formularioEdicao.render(form(GrupoPesquisa.class).fill(grupos), grupos));
		}
		
		//Deletar
		public static Result deletar(Long id){
			GrupoPesquisa grupos = GrupoPesquisa.find.byId(id);
			if(grupos == null){
				flash().put("error", "O Grupo de Pesquisa informado não foi encontrado no Sistema.");
			}else{
				grupos.delete();
				flash().put("success", "Grupo de Pesquisa\""+ grupos.nome +"\" excluído com sucesso!");
			}
			
			return redirect(routes.GrupoPesquisaController.index());
		}
		

} //final
