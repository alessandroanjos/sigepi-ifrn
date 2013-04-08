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

	// Result
	public static Result index() {

		List<GrupoPesquisa> gruposPesquisa = GrupoPesquisa.find.findList();

		return ok(views.html.GrupoPesquisa.index.render(gruposPesquisa));
	}

	// Visualizar
	public static Result visualizar(Long id) {

		GrupoPesquisa gruposPesquisa = GrupoPesquisa.find.byId(id);
		if (gruposPesquisa == null) {
			flash().put("error","O Grupo de Pesquisa informado não foi encontrado no Sistema.");
			return redirect(routes.GrupoPesquisaController.index());
		}

		return ok(views.html.GrupoPesquisa.visualizar.render(gruposPesquisa));
	}

	// Permissão para Administrador
	@Permissao("Administrador")
	public static Result formulario() {
		List<Campus> campus = Campus.find.findList();
		return ok(views.html.GrupoPesquisa.formulario.render(
				form(GrupoPesquisa.class), campus));
	}

	// Cadastrar
	@Permissao("Administrador")
	public static Result cadastrar() {

		Form<GrupoPesquisa> form = form(GrupoPesquisa.class).bindFromRequest();
		Long idCampus = Long.valueOf(form.data().get("idCampus"));

		if (form.hasErrors()) {

			List<Campus> campus = Campus.find.findList();

			flash().put("error","Você deve preencher o campo corretamente. Tente novamente!");
			return badRequest(views.html.GrupoPesquisa.formulario.render(form,
					campus));
		}

		GrupoPesquisa grupos = form.get();
		grupos.campus = Campus.find.byId(idCampus);
		grupos.save();

		flash().put("success","Grupo de Pesquisa \"" + grupos.nome + "\" Cadastrado com Sucesso!");

		return redirect(routes.GrupoPesquisaController.index());
	}

	// Editar
	public static Result editar(Long id) {

		Form<GrupoPesquisa> form = form(GrupoPesquisa.class).bindFromRequest();
		GrupoPesquisa grupos = GrupoPesquisa.find.byId(id);

		if (form.hasErrors()) {
			List<Campus> campus = Campus.find.findList();
			flash().put("error", "Você deve preencher todos os campos corretamente. Tente novamente!");
			return badRequest(views.html.GrupoPesquisa.formularioEdicao.render(
					(form), grupos, campus));
		}

		grupos.setNome(form.get().nome);
		grupos.setCampus(Campus.find.byId(Long.valueOf(form.data().get(
				"idCampus"))));
		grupos.update();

		flash().put("success","Grupo de Pesquisa \"" + grupos.nome+ "\" atualizado com sucesso!");
		return redirect(routes.GrupoPesquisaController.index());
	}

		//Formulario Edição
	public static Result formularioEdicao(Long id) {
		GrupoPesquisa grupos = GrupoPesquisa.find.byId(id);
		List<Campus> campus = Campus.find.findList();
		
		if(grupos == null){
			flash().put("error", "O Grupo de Pesquisa informado não foi encontrado no Sistema.");
			return redirect(routes.GrupoPesquisaController.index());
		}

		return ok(views.html.GrupoPesquisa.formularioEdicao.render(
				form(GrupoPesquisa.class).fill(grupos), grupos, campus));
	}
		
	// Deletar
	public static Result deletar(Long id) {
		GrupoPesquisa grupos = GrupoPesquisa.find.byId(id);
		if (grupos == null) {
			flash().put("error", "O Grupo de Pesquisa informado não foi encontrado no Sistema.");
		} else if(grupos.projetos.size() > 0 || grupos.usuarios.size() > 0 ){
			flash().put("error", "O Grupo de Pesquisa não pode ser excluído, pois existem outros objetos impedindo a sua exclusão!");
		}else {
			grupos.delete();
			flash().put("success",  "Grupo de Pesquisa \"" + grupos.nome	+ "\" excluído com sucesso!");
		}

		return redirect(routes.GrupoPesquisaController.index());
	}

} //final
