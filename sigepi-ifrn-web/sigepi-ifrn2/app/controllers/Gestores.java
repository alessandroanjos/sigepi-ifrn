package controllers;

import forms.AlterarUsuarioForm;
import helpers.Seguranca.InformacoesUsuarioHelper;

import java.util.List;

import models.Campus;
import models.Usuario;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Gestores extends Controller{

	 /**
     * Inicio da área do Gestor
     */
	@helpers.Seguranca.Permissao("Gestor")
	public static Result index(){
		return ok(views.html.Gestor.index.render());
	}
	
	@helpers.Seguranca.Permissao("Administrador")
	public static Result listaGestores(){
		
		List<Usuario> gestores = Usuario.find.where().eq("isGestor", true).findList();
		
		return ok(views.html.Gestor.listaGestores.render(gestores));
		
	}
	
	
	
	public static Result formulario(){
		List<Campus> campus = Campus.find.findList();
		
		return ok(views.html.Gestor.formulario.render(form(Usuario.class), campus));
	}
	
	public static Result cadastrar() {
		Form<Usuario> form = form(Usuario.class).bindFromRequest();
		Long idCampus = Long.valueOf(form.data().get("idCampus"));
		
		
		
		if(form.hasErrors() || !form.get().senha.equals(form.data().get("confirmacaoSenha"))) {
			
			List<Campus> campus = Campus.find.findList();
			
			flash().put("error", "Você deve preencher todos os campos corretamente. Tente novamente!");
			return badRequest(views.html.Gestor.formulario.render(form, campus));
		}
		
		Usuario gestor = form.get();
		gestor.isAtivo = true;
		gestor.isGestor = true;
		gestor.campus = Campus.find.byId(idCampus);
		gestor.save();
		
		// Envia o email de confirmação de cadastro no sistema!
		//RegistroMailer.enviarMensagemRegistro(professor);
		
		flash().put("success", "Gestor \""+ gestor.nome +"\" cadastrado com sucesso!");
		
		
			return redirect(routes.Administracao.index());
		
	}
	
	
	@helpers.Seguranca.Permissao("Administrador")
	public static Result formularioEdicao(Long id) {
		Usuario gestor = Usuario.find.byId(id);
		List<Campus> campus  = Campus.find.findList();
		
		AlterarUsuarioForm formulario = new AlterarUsuarioForm();
		formulario.nome = gestor.nome;
		formulario.email = gestor.email;
		
		return ok(views.html.Gestor.formularioEdicao.render(form(AlterarUsuarioForm.class).fill(formulario), gestor, campus));
	}
	
	@helpers.Seguranca.Permissao("Administrador")
	public static Result editar(Long id) {
		Form<AlterarUsuarioForm> form = form(AlterarUsuarioForm.class).bindFromRequest();
		Usuario gestor = Usuario.find.byId(id);
		
		if(form.hasErrors()) {
			List<Campus> campus  = Campus.find.findList();
			flash().put("error", "Você deve preencher todos os campos corretamente. Tente novamente!");
			return badRequest(views.html.Gestor.formularioEdicao.render(form, gestor, campus));
		}
		
		gestor.setCampus(Campus.find.byId(Long.valueOf(form.data().get("idCampus"))));
		gestor.setNome(form.get().nome);
		gestor.setEmail(form.get().email);
		gestor.update();
		
		flash().put("success", "Gestor \""+ gestor.nome +"\" atualizado com sucesso!");
		return redirect(routes.Gestores.listaGestores());
	}
	
	@helpers.Seguranca.Permissao("Administrador")
	public static Result deletar(Long id) {
		Usuario gestor = Usuario.find.byId(id);
		
		if (gestor == null) {
			flash().put("error", "O Gestor informado não foi encontrado no Sistema.");
		} else {
			gestor.delete();
			
			//RegistroMailer.enviarMensagemExclusao(professor);
			
			flash().put("success", "Gestor \""+ gestor.nome +"\" excluído com sucesso!");
		}
		
		return redirect(routes.Gestores.listaGestores());
	}
}
