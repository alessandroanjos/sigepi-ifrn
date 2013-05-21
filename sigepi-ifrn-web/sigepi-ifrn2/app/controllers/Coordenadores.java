package controllers;

import java.util.List;

import models.AreaConhecimento;
import models.Campus;
import models.GrupoPesquisa;
import models.Projeto;
import models.ProjetoAvaliado;
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

		try {
			Form<Usuario> form = form(Usuario.class).bindFromRequest();
			Long idCampus = Long.valueOf(form.data().get("idCampus"));
			Long idAreaConhecimento = Long.valueOf(form.data().get(
					"idAreaConhecimento"));
			Long idGrupoPesquisa = Long.valueOf(form.data().get(
					"idGrupoPesquisa"));

			if (form.hasErrors() || !form.get().senha.equals(form.data().get("confirmacaoSenha"))
					|| !form.get().validaCPF(form.get().cpf) ){

				List<Campus> campus = Campus.find.findList();
				List<AreaConhecimento> areas = AreaConhecimento.find.findList();
				List<GrupoPesquisa> grupos = GrupoPesquisa.find.findList();

				flash().put("error",
						"Você deve preencher todos os campos corretamente. Tente novamente!");
				return badRequest(views.html.Coordenadores.formulario.render(
						form, campus, areas, grupos));
			}

			Usuario cordenador = form.get();
			cordenador.isAtivo = true;
			cordenador.isProfessor = true;
			cordenador.isCoordenador = true;
			cordenador.campus = Campus.find.byId(idCampus);
			cordenador.areaConhecimento = AreaConhecimento.find
					.byId(idAreaConhecimento);
			cordenador.grupoPesquisa = GrupoPesquisa.find.byId(idGrupoPesquisa);

			if (cordenador.grupoPesquisa.campus.id == idCampus) {
				cordenador.save();
				flash().put(
						"success",
						"Coordenador \"" + cordenador.nome
								+ "\" cadastrado com sucesso!");
			} else {
				flash().put("error",
						"O seu Grupo de Pesquisa não bate com o seu Campus. Tente novamente!");
				List<Campus> campus = Campus.find.findList();
				List<AreaConhecimento> areas = AreaConhecimento.find.findList();
				List<GrupoPesquisa> grupos = GrupoPesquisa.find.findList();
				return badRequest(views.html.Coordenadores.formulario.render(
						form, campus, areas, grupos));
			}
			// Envia o email de confirmação de cadastro no sistema!
			// RegistroMailer.enviarMensagemRegistro(professor);
			return redirect(routes.Administracao.index());

		} catch (Exception e) {
			e.printStackTrace();
			flash().put(
					"error",
					"Não foi possível fazer o seu cadastro no sistema. Talvez alguns dos dados informados já existam na base de dados. Tente Novamente!");
			Form<Usuario> form = form(Usuario.class).bindFromRequest();
			List<Campus> campus = Campus.find.findList();
			List<AreaConhecimento> areas = AreaConhecimento.find.findList();
			List<GrupoPesquisa> grupos = GrupoPesquisa.find.findList();
			return badRequest(views.html.Coordenadores.formulario.render(form,
					campus, areas, grupos));
		}

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
		formulario.cpf = cordenador.cpf;
		
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
		coordenador.setCpf(form.get().cpf);
		coordenador.update();
		
		flash().put("success", "Coordenador \""+ coordenador.nome +"\" atualizado com sucesso!");
		return redirect(routes.Coordenadores.listaCoordenadores());
	}
	
	@helpers.Seguranca.Permissao("Administrador")
	public static Result deletar(Long id) {
		Usuario coordenador = Usuario.find.byId(id);

		if (coordenador == null) {
			flash().put("error", "O Coordenador informado não foi encontrado no Sistema.");
		} else {
			//primeiro eu deleto os projetos que o prof avaliou
    		List<ProjetoAvaliado> projetoAvaliados = ProjetoAvaliado.find.where().eq("usuario_id", id).findList();
    		for (ProjetoAvaliado p: projetoAvaliados){
    			 p.delete();
    		}

    		//segundo eu deleto os projetos que ele submeteu e q foram avaliados
    		List<ProjetoAvaliado> projetosAvaliados = ProjetoAvaliado.find.where().findList();   //todos os projetos avaliados		
    		List<Projeto> projetosSubmetidosProfessor = Projeto.find.where().eq("autor_id", id).findList(); //todos os projetos submetidos pelo profe que eu quero excluir	
			for (Projeto projeto : projetosSubmetidosProfessor) {

				for (ProjetoAvaliado projetoAv : projetosAvaliados) {
					if(projeto.id.equals(projetoAv.projeto.id)){
						projetoAv.delete();
					}
				}
				//terceiro eu excluo os projetos que ele submeteu
				projeto.delete();
			}
			//depois eu excluo o coordenador  
			coordenador.delete();
			//RegistroMailer.enviarMensagemExclusao(professor);
			
			flash().put("success", "Coordenador \""+ coordenador.nome +"\" excluído com sucesso!");
		}
		
		return redirect(routes.Coordenadores.listaCoordenadores());
	}

	/**
	 * Retorna a informação que o cpf é inválido.
	 * 
	 * @return
	 */
	public static Result badRequestCadastroCoordenadorCPF(){
		Form<Usuario> form = form(Usuario.class).bindFromRequest();
		List<Campus> campus = Campus.find.findList();
		List<AreaConhecimento> areas = AreaConhecimento.find.findList();
		List<GrupoPesquisa> grupos = GrupoPesquisa.find.findList();

		flash().put("error", "O CPF informado é inválido! Tente novamente!");
		return badRequest(views.html.Coordenadores.formulario.render(form,campus, areas, grupos));
	}
}
