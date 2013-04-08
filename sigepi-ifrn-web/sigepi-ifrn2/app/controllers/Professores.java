package controllers;

import forms.AlterarUsuarioForm;
import helpers.Seguranca.InformacoesUsuarioHelper;

import java.util.List;


import models.AreaConhecimento;
import models.Campus;
import models.Edital;
import models.GrupoPesquisa;
import models.Usuario;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Professores extends Controller{

	
	 /**
     * Inicio da área do professor
     */
	@helpers.Seguranca.Permissao("Professor")
	public static Result index(){
		return ok(views.html.Professor.index.render());
	}
	
	@helpers.Seguranca.Permissao("Administrador")
	public static Result listaProfessores(){
		
		List<Usuario> professores = Usuario.find.where().eq("isProfessor", true).findList();
		
		return ok(views.html.Professor.listaProfessores.render(professores));
		
	}
	
	
	public static Result formulario(){
		List<Campus> campus = Campus.find.findList();
		List<AreaConhecimento> areas = AreaConhecimento.find.findList();
		List<GrupoPesquisa> grupos = GrupoPesquisa.find.findList();
		
		return ok(views.html.Professor.formulario.render(form(Usuario.class), campus, areas, grupos));
	}
	
	public static Result cadastrar() {
		Form<Usuario> form = form(Usuario.class).bindFromRequest();
		Long idCampus = Long.valueOf(form.data().get("idCampus"));
		Long idAreaConhecimento = Long.valueOf(form.data().get("idAreaConhecimento"));
		Long idGrupoPesquisa  = Long.valueOf(form.data().get("idGrupoPesquisa"));
		
		
		
		if(form.hasErrors() || !form.get().senha.equals(form.data().get("confirmacaoSenha"))) {
			
			List<Campus> campus = Campus.find.findList();
			List<AreaConhecimento> areas = AreaConhecimento.find.findList();
			List<GrupoPesquisa> grupos = GrupoPesquisa.find.findList();

			flash().put("error", "Você deve preencher todos os campos corretamente. Tente novamente!");
			return badRequest(views.html.Professor.formulario.render(form, campus, areas, grupos));
		}
		
		Usuario professor = form.get();
		professor.isAtivo = true;
		professor.isProfessor = true;
		professor.campus = Campus.find.byId(idCampus);
		professor.areaConhecimento = AreaConhecimento.find.byId(idAreaConhecimento);
		professor.grupoPesquisa = GrupoPesquisa.find.byId(idGrupoPesquisa);
		
		if(professor.grupoPesquisa.campus.id == idCampus){
			professor.save();
			flash().put("success", "Professor \""+ professor.nome +"\" cadastrado com sucesso!");
		} else {
			flash().put("error", "O seu Grupo de Pesquisa não bate com o seu Campus. Tente novamente!");
			return redirect(routes.Professores.formulario());
		}		
		// Envia o email de confirmação de cadastro no sistema!
		//RegistroMailer.enviarMensagemRegistro(professor);
		return redirect(routes.Administracao.index());

	}
	
	@helpers.Seguranca.Permissao("Administrador")
	public static Result formularioEdicao(Long id) {
		Usuario professor = Usuario.find.byId(id);
		List<Campus> campus  = Campus.find.findList();
		List<AreaConhecimento> areas = AreaConhecimento.find.findList();
		List<GrupoPesquisa> grupos = GrupoPesquisa.find.findList();
		
		AlterarUsuarioForm formulario = new AlterarUsuarioForm();
		formulario.nome = professor.nome;
		formulario.email = professor.email;
		
		return ok(views.html.Professor.formularioEdicao.render(form(AlterarUsuarioForm.class).fill(formulario), professor, campus, areas, grupos));
	}
	
	@helpers.Seguranca.Permissao("Administrador")
	public static Result editar(Long id) {
		Form<AlterarUsuarioForm> form = form(AlterarUsuarioForm.class).bindFromRequest();
		Usuario professor = Usuario.find.byId(id);
		
		if(form.hasErrors()) {
			List<Campus> campus  = Campus.find.findList();
			List<AreaConhecimento> areas = AreaConhecimento.find.findList();
			List<GrupoPesquisa> grupos = GrupoPesquisa.find.findList();
			
			flash().put("error", "Você deve preencher todos os campos corretamente. Tente novamente!");
			return badRequest(views.html.Professor.formularioEdicao.render(form, professor, campus, areas, grupos));
		}
		
		professor.setCampus(Campus.find.byId(Long.valueOf(form.data().get("idCampus"))));
		professor.setAreaConhecimento(AreaConhecimento.find.byId(Long.valueOf(form.data().get("idAreaConhecimento"))));
		professor.setGrupoPesquisa(GrupoPesquisa.find.byId(Long.valueOf(form.data().get("idGrupoPesquisa"))));
		professor.setNome(form.get().nome);
		professor.setEmail(form.get().email);
		
		Long idCampus = Long.valueOf(form.data().get("idCampus"));
		
		if(professor.grupoPesquisa.campus.id == idCampus){
				professor.update();
				flash().put("success", "Professor \""+ professor.nome +"\" atualizado com sucesso!");		
		} else {
			flash().put("error", "O Grupo de Pesquisa não bate com o Campus. Tente novamente!");
			return redirect(routes.Professores.formularioEdicao(id));
		}		
		
		return redirect(routes.Professores.listaProfessores());
	}
	
	@helpers.Seguranca.Permissao("Administrador")
	public static Result deletar(Long id) {
		Usuario professor = Usuario.find.byId(id);
		
		if (professor == null) {
			flash().put("error", "O Professor informado não foi encontrado no Sistema.");
		} else if(professor.progresso.size()> 0 || professor.projetos.size() > 0){
			flash().put("error", "O Professor não pode ser excluído, pois existem outros recursos impedindo de excluí-lo.");
		} else {
			professor.delete();
			//RegistroMailer.enviarMensagemExclusao(professor);
			flash().put("success", "Professor \""+ professor.nome +"\" excluído com sucesso!");
		}
		
		return redirect(routes.Professores.listaProfessores());
	}
}
