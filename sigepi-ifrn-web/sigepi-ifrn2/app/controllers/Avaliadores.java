package controllers;

import forms.AlterarUsuarioForm;
import helpers.Seguranca.Permissao;

import java.util.List;

import models.Campus;
import models.Usuario;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Avaliadores extends Controller {

	/**
     * Area de incio do Avaliador
     */
	@helpers.Seguranca.Permissao("Avaliador")
	public static Result index(){
		return ok(views.html.Avaliador.index.render());
	}
	
	//@helpers.Seguranca.Permissao("Administrador")
	public static Result listaAvaliadores(){
		
		List<Usuario> avaliadores = Usuario.find.where().eq("isAvaliador", true).findList();
		
		return ok(views.html.Avaliador.listaAvaliadores.render(avaliadores));
		
	}
	
	
	//@Permissao("Administrador")
	public static Result formulario(){
		List<Campus> campus = Campus.find.findList();
		
		return ok(views.html.Avaliador.formulario.render(form(Usuario.class), campus));
	}
	
	//@Permissao("Administrador")
	public static Result cadastrar() {
		Form<Usuario> form = form(Usuario.class).bindFromRequest();
		Long idCampus = Long.valueOf(form.data().get("idCampus"));
		
		
		
		if(form.hasErrors() || !form.get().senha.equals(form.data().get("confirmacaoSenha"))) {
			
			List<Campus> campus = Campus.find.findList();
			
			flash().put("error", "Você deve preencher todos os campos corretamente. Tente novamente!");
			return badRequest(views.html.Avaliador.formulario.render(form, campus));
		}
		
		Usuario avaliador = form.get();
		avaliador.isAtivo = true;
		avaliador.isAvaliador = true;
		avaliador.campus = Campus.find.byId(idCampus);
		avaliador.save();
		
		// Envia o email de confirmação de cadastro no sistema!
		//RegistroMailer.enviarMensagemRegistro(professor);
		
		flash().put("success", "Avaliador \""+ avaliador.nome +"\" cadastrado com sucesso!");
		
		
			return redirect(routes.Administracao.index());
		
	}
	
	
	//@helpers.Seguranca.Permissao("Administrador")
	public static Result formularioEdicao(Long id) {
		Usuario avaliador = Usuario.find.byId(id);
		List<Campus> campus  = Campus.find.findList();
		
		AlterarUsuarioForm formulario = new AlterarUsuarioForm();
		formulario.nome = avaliador.nome;
		formulario.email = avaliador.email;
		
		return ok(views.html.Avaliador.formularioEdicao.render(form(AlterarUsuarioForm.class).fill(formulario), avaliador, campus));
	}
	
	//@helpers.Seguranca.Permissao("Administrador")
	public static Result editar(Long id) {
		Form<AlterarUsuarioForm> form = form(AlterarUsuarioForm.class).bindFromRequest();
		Usuario avaliador = Usuario.find.byId(id);
		
		if(form.hasErrors()) {
			List<Campus> campus  = Campus.find.findList();
			flash().put("error", "Você deve preencher todos os campos corretamente. Tente novamente!");
			return badRequest(views.html.Avaliador.formularioEdicao.render(form, avaliador, campus));
		}
		
		avaliador.setCampus(Campus.find.byId(Long.valueOf(form.data().get("idCampus"))));
		avaliador.setNome(form.get().nome);
		avaliador.setEmail(form.get().email);
		avaliador.update();
		
		flash().put("success", "Avaliador \""+ avaliador.nome +"\" atualizado com sucesso!");
		return redirect(routes.Avaliadores.listaAvaliadores());
	}
	
	//@helpers.Seguranca.Permissao("Administrador")
	public static Result deletar(Long id) {
		Usuario avaliador = Usuario.find.byId(id);
		
		if (avaliador == null) {
			flash().put("error", "O Avaliador informado não foi encontrado no Sistema.");
		} else {
			avaliador.delete();
			
			//RegistroMailer.enviarMensagemExclusao(professor);
			
			flash().put("success", "Avaliador \""+ avaliador.nome +"\" excluído com sucesso!");
		}
		
		return redirect(routes.Avaliadores.listaAvaliadores());
	}
}
