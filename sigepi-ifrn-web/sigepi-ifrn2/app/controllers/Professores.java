package controllers;

import forms.AlterarUsuarioForm;
import helpers.Seguranca.InformacoesUsuarioHelper;

import java.util.List;


import models.Campus;
import models.Edital;
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
		
		return ok(views.html.Professor.formulario.render(form(Usuario.class), campus));
	}
	
	public static Result cadastrar() {
		Form<Usuario> form = form(Usuario.class).bindFromRequest();
		Long idCampus = Long.valueOf(form.data().get("idCampus"));
		
		
		
		if(form.hasErrors() || !form.get().senha.equals(form.data().get("confirmacaoSenha"))) {
			
			List<Campus> campus = Campus.find.findList();
			
			flash().put("error", "Você deve preencher todos os campos corretamente. Tente novamente!");
			return badRequest(views.html.Professor.formulario.render(form, campus));
		}
		
		Usuario professor = form.get();
		professor.isAtivo = true;
		professor.isProfessor = true;
		professor.campus = Campus.find.byId(idCampus);
		professor.save();
		
		// Envia o email de confirmação de cadastro no sistema!
		//RegistroMailer.enviarMensagemRegistro(professor);
		
		flash().put("success", "Professor \""+ professor.nome +"\" cadastrado com sucesso!");
		
		
			return redirect(routes.Administracao.index());

	}
	
	@helpers.Seguranca.Permissao("Administrador")
	public static Result formularioEdicao(Long id) {
		Usuario professor = Usuario.find.byId(id);
		List<Campus> campus  = Campus.find.findList();
		
		AlterarUsuarioForm formulario = new AlterarUsuarioForm();
		formulario.nome = professor.nome;
		formulario.email = professor.email;
		
		return ok(views.html.Professor.formularioEdicao.render(form(AlterarUsuarioForm.class).fill(formulario), professor, campus));
	}
	
	@helpers.Seguranca.Permissao("Administrador")
	public static Result editar(Long id) {
		Form<AlterarUsuarioForm> form = form(AlterarUsuarioForm.class).bindFromRequest();
		Usuario professor = Usuario.find.byId(id);
		
		if(form.hasErrors()) {
			List<Campus> campus  = Campus.find.findList();
			flash().put("error", "Você deve preencher todos os campos corretamente. Tente novamente!");
			return badRequest(views.html.Professor.formularioEdicao.render(form, professor, campus));
		}
		
		professor.setCampus(Campus.find.byId(Long.valueOf(form.data().get("idCampus"))));
		professor.setNome(form.get().nome);
		professor.setEmail(form.get().email);
		professor.update();
		
		flash().put("success", "Professor \""+ professor.nome +"\" atualizado com sucesso!");
		return redirect(routes.Professores.listaProfessores());
	}
	
	@helpers.Seguranca.Permissao("Administrador")
	public static Result deletar(Long id) {
		Usuario professor = Usuario.find.byId(id);
		
		if (professor == null) {
			flash().put("error", "O Professor informado não foi encontrado no Sistema.");
		} else {
			professor.delete();
			
			//RegistroMailer.enviarMensagemExclusao(professor);
			
			flash().put("success", "Professor \""+ professor.nome +"\" excluído com sucesso!");
		}
		
		return redirect(routes.Professores.listaProfessores());
	}
}
