package controllers;

import helpers.Seguranca.InformacoesUsuarioHelper;
import helpers.Seguranca.Permissao;

import java.util.Date;
import java.util.List;

import models.Campus;
import models.Edital;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class CampusController extends Controller {

	public static Result index(){		
		
		List<Campus> campus = Campus.find.findList();
		
		return ok(views.html.Campus.index.render(campus));
	}
	
	public static Result visualizar(Long id){
		
		Campus campus = Campus.find.byId(id);
		if(campus == null){
			flash().put("error", "O Campus informado não foi encontrado no Sistema.");
			return redirect(routes.CampusController.index());
		}
		return ok(views.html.Campus.visualizar.render(campus));
	}
	
	@Permissao("Administrador")
	public static Result formulario() {
		return ok(views.html.Campus.formulario.render(form(Campus.class)));
	}
	
	@Permissao("Administrador")
	public static Result cadastrar(){
		
		Form<Campus> form = form(Campus.class).bindFromRequest();
		
		if(form.hasErrors()){
			flash().put("error", "Você deve preencher o campo corretamente. Tente novamente!");
			return badRequest(views.html.Campus.formulario.render(form));
		}
		
		Campus campus = form.get();
		/*campus.autor = InformacoesUsuarioHelper.getUsuarioLogado();*/				
		campus.save();
		
		flash().put("success", "Campus \""+campus.nome +"\" Cadastrado com Sucesso!");
		
		return redirect(routes.CampusController.index());
	}
	
	
		
	public static Result editar(Long id) {
		
		Form<Campus> form = form(Campus.class).bindFromRequest();
		Campus campus = Campus.find.byId(id);
		
		if(form.hasErrors()) {
			flash().put("error", "Você deve preencher todos os campos corretamente. Tente novamente!");
			return badRequest(views.html.Campus.formularioEdicao.render((form), campus));
		}
		
		campus.setNome(form.get().nome);
		campus.update();
		
		flash().put("success", "Campus \""+ campus.nome +"\" atualizado com sucesso!");
		return redirect(routes.CampusController.index());
	}
	
	
	public static Result formularioEdicao(Long id) {
		Campus campus = Campus.find.byId(id);
		if(campus == null){
			flash().put("error", "O Campus informado não foi encontrado no Sistema.");
			return redirect(routes.CampusController.index());
		}
		return ok(views.html.Campus.formularioEdicao.render(form(Campus.class).fill(campus), campus));
	}
	
	public static Result deletar(Long id){
		Campus campus = Campus.find.byId(id);
		if(campus == null){
			flash().put("error", "O Campus informado não foi encontrado no Sistema.");
		}else if(campus.projetos.size() > 0 || campus.bolsistas.size() > 0 ){
			flash().put("error", "O Campus não pode ser excluído, pois existem outros objetos impedindo a sua exclusão!");
		}else {
			campus.delete();
			flash().put("success", "Campus \""+ campus.nome +"\" excluído com sucesso!");
		}
		
		return redirect(routes.CampusController.index());
	}
}
