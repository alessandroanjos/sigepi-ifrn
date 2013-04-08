package controllers;

import java.util.List;

import models.AreaConhecimento;
import models.Campus;
import models.GrupoPesquisa;
import models.Usuario;
import forms.AlterarUsuarioForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Classe controladora de Coordenadores.
 * @author Alessandro
 *
 */
public class Coordenadores extends Controller{
	
	@helpers.Seguranca.Permissao("Administrador")
	public static Result listaCoordenadores(){
		
		List<Usuario> coordenadores = Usuario.find.where().eq("isCoordenador", true).findList();
		
		return ok(views.html.Coordenadores.listaCoordenadores.render(coordenadores));
		
	}
	
	
	public static Result formulario(){
		List<Campus> campus = Campus.find.findList();
		List<AreaConhecimento> areas = AreaConhecimento.find.findList();
		List<GrupoPesquisa> grupos = GrupoPesquisa.find.findList();
		
		return ok(views.html.Coordenadores.formulario.render(form(Usuario.class), campus, areas, grupos));
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
			return badRequest(views.html.Coordenadores.formulario.render(form, campus, areas, grupos));
		}
		
		Usuario cordenador = form.get();
		cordenador.isAtivo = true;
		cordenador.isProfessor = true;
		cordenador.isCoordenador = true;
		cordenador.campus = Campus.find.byId(idCampus);
		cordenador.areaConhecimento = AreaConhecimento.find.byId(idAreaConhecimento);
		cordenador.grupoPesquisa = GrupoPesquisa.find.byId(idGrupoPesquisa);

		if(cordenador.grupoPesquisa.campus.id == idCampus){
			cordenador.save();
			flash().put("success", "Coordenador \""+ cordenador.nome +"\" cadastrado com sucesso!");
		} else {
			flash().put("error", "O seu Grupo de Pesquisa não bate com o seu Campus. Tente novamente!");
			return redirect(routes.Coordenadores.formulario());
		}
		// Envia o email de confirmação de cadastro no sistema!
		//RegistroMailer.enviarMensagemRegistro(professor);
    	return redirect(routes.Administracao.index());

	}
	
	@helpers.Seguranca.Permissao("Administrador")
	public static Result formularioEdicao(Long id) {
		Usuario cordenador = Usuario.find.byId(id);
		List<Campus> campus  = Campus.find.findList();
		List<AreaConhecimento> areas = AreaConhecimento.find.findList();
		List<GrupoPesquisa> grupos = GrupoPesquisa.find.findList();
		
		AlterarUsuarioForm formulario = new AlterarUsuarioForm();
		formulario.nome = cordenador.nome;
		formulario.email = cordenador .email;
		
		return ok(views.html.Coordenadores.formularioEdicao.render(form(AlterarUsuarioForm.class).fill(formulario), cordenador, campus, areas, grupos));
	}
	
	@helpers.Seguranca.Permissao("Administrador")
	public static Result editar(Long id) {
		Form<AlterarUsuarioForm> form = form(AlterarUsuarioForm.class).bindFromRequest();
		Usuario coordenador = Usuario.find.byId(id);
		
		if(form.hasErrors()) {
			List<Campus> campus  = Campus.find.findList();
			List<AreaConhecimento> areas = AreaConhecimento.find.findList();
			List<GrupoPesquisa> grupos = GrupoPesquisa.find.findList();
			
			flash().put("error", "Você deve preencher todos os campos corretamente. Tente novamente!");
			return badRequest(views.html.Coordenadores.formularioEdicao.render(form, coordenador, campus, areas, grupos));
		}
		
		coordenador.setCampus(Campus.find.byId(Long.valueOf(form.data().get("idCampus"))));
		coordenador.setAreaConhecimento(AreaConhecimento.find.byId(Long.valueOf(form.data().get("idAreaConhecimento"))));
		coordenador.setGrupoPesquisa(GrupoPesquisa.find.byId(Long.valueOf(form.data().get("idGrupoPesquisa"))));
		coordenador.setNome(form.get().nome);
		coordenador.setEmail(form.get().email);
		coordenador.update();
		
		flash().put("success", "Coordenador \""+ coordenador.nome +"\" atualizado com sucesso!");
		return redirect(routes.Coordenadores.listaCoordenadores());
	}
	
	@helpers.Seguranca.Permissao("Administrador")
	public static Result deletar(Long id) {
		Usuario cordenador = Usuario.find.byId(id);
		
		if (cordenador == null) {
			flash().put("error", "O Professor informado não foi encontrado no Sistema.");
		} else {
			cordenador.delete();
			
			//RegistroMailer.enviarMensagemExclusao(professor);
			
			flash().put("success", "Coordenador \""+ cordenador.nome +"\" excluído com sucesso!");
		}
		
		return redirect(routes.Coordenadores.listaCoordenadores());
	}
}
