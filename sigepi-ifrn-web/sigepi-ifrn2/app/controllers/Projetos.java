package controllers;

import forms.LoginForm;
import forms.ProjetoForm;
import helpers.Pontuacao.PontuacaoComparator;
import helpers.Seguranca.Permissao;
import helpers.Seguranca.InformacoesUsuarioHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import models.Campus;
import models.Edital;
import models.Projeto;
import models.ProjetoAvaliado;
import models.Usuario;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Projetos extends Controller{

	//@Permissao("Administrador")
	public static Result index(){
		//List<Projeto> projetos = Projeto.find.findList();
		
		//pegando o id do campus do usuario q está logado atualmente
		Long campusId = InformacoesUsuarioHelper.getUsuarioLogado().campus.id;
		
		
		
		
		if (InformacoesUsuarioHelper.getUsuarioLogado().isAdministrador
				|| InformacoesUsuarioHelper.getUsuarioLogado().isAvaliador
				|| InformacoesUsuarioHelper.getUsuarioLogado().isGestor) {
		
			//listo os projetos q batem com o mesmo resultado de campus iguais.
			List<Projeto> projetos = Projeto.find.where()
					.eq("campus_id", campusId).findList();
			
			return ok(views.html.Projetos.index.render(projetos));
		}else{
			flash().put("error", "Você não tem permissão para ver os projetos!");
			//redirect(routes.Sessions.login());
		}
		
		return ok(views.html.Professor.index.render());
		
	}
	
	public static Result visualizar(Long id) {
		Form<ProjetoForm> form = form(ProjetoForm.class);
		Projeto projeto = Projeto.find.byId(id);
		
		if (InformacoesUsuarioHelper.getUsuarioLogado().isAdministrador || InformacoesUsuarioHelper.getUsuarioLogado().isAvaliador
			|| InformacoesUsuarioHelper.getUsuarioLogado().isGestor	) {
			
			if(projeto.campus.id == InformacoesUsuarioHelper.getUsuarioLogado().campus.id){
				return ok(views.html.Projetos.visualizar2.render(projeto));
			}else{
				flash().put("error", "Projeto de campus diferente. Tente novamente!");
				redirect(routes.Projetos.index());
			}
			
			return ok(views.html.Projetos.visualizar.render(projeto));
		}
		else{
			return ok(views.html.Projetos.visualizar.render(projeto));
		}
			
	}
	
	@Permissao("Professor")	
	public static Result formulario() {
		List<Edital> editais = Edital.find.findList();
		List<Campus> campus  = Campus.find.findList();
		
		return ok(views.html.Projetos.formulario.render(form(Projeto.class), editais, campus));
	}
	
	@Permissao("Professor")
	public static Result submeter() {
		Form<Projeto> form = form(Projeto.class).bindFromRequest();
		Long idEdital = Long.valueOf(form.data().get("idEdital"));
		Long idCampus = Long.valueOf(form.data().get("idCampus"));
		
		if(form.hasErrors()) {
			List<Edital> editais = Edital.find.findList();
			List<Campus> campus  = Campus.find.findList();
			
			flash().put("error", "Você deve preencher todos os campos corretamente. Tente novamente!");
			return badRequest(views.html.Projetos.formulario.render(form, editais, campus));
		}
		
		Projeto projeto = form.get();
		projeto.autor = InformacoesUsuarioHelper.getUsuarioLogado();
		projeto.edital = Edital.find.byId(idEdital);
		projeto.campus = Campus.find.byId(idCampus);
		
		projeto.save();
		
		flash().put("success", "Projeto \""+ projeto.titulo +"\" submetido com sucesso à Pró-Reitoria de Pesquisa!");
		return redirect(routes.Projetos.meusProjetos());
	}
	
	
	@Permissao("Administrador")
	public static Result formularioEdicao(Long id) {
		List<Edital> editais = Edital.find.findList();
		List<Campus> campus  = Campus.find.findList();
		
		Projeto projeto = Projeto.find.byId(id);
		
		return ok(views.html.Projetos.formularioEdicao.render(form(Projeto.class).fill(projeto), editais, campus , projeto));
	}
	
	
	@Permissao("Administrador")
	public static Result editar(Long id) {
		Form<Projeto> form = form(Projeto.class).bindFromRequest();
		Projeto projeto = Projeto.find.byId(id);
		
		if(form.hasErrors()) {
			List<Edital> editais = Edital.find.findList();
			List<Campus> campus  = Campus.find.findList();
			
			flash().put("error", "Você deve preencher todos os campos corretamente. Tente novamente!");
			return badRequest(views.html.Projetos.formularioEdicao.render(form, editais, campus, projeto));
		}
		
		projeto.setEdital(Edital.find.byId(Long.valueOf(form.data().get("idEdital"))));
		projeto.setCampus(Campus.find.byId(Long.valueOf(form.data().get("idCampus"))));
		projeto.setTitulo(form.get().titulo);
		projeto.setResumo(form.get().resumo);
		projeto.setIntroducao(form.get().introducao);
		projeto.setFundamentacaoTeorica(form.get().fundamentacaoTeorica);
		projeto.setJustificativa(form.get().justificativa);
		projeto.setObjetivos(form.get().objetivos);
		projeto.setMetodologia(form.get().metodologia);
		projeto.setReferencias(form.get().referencias);
		projeto.update();
				
		flash().put("success", "Projeto \""+ projeto.titulo +"\" atualizado com sucesso!");
		return redirect(routes.Projetos.index());
	}
	
	@Permissao("Administrador")
	public static Result deletar(Long id) {
		Projeto projeto = Projeto.find.byId(id);
		
		if (projeto == null) {
			flash().put("error", "O Projeto informado não foi encontrado no Sistema.");
		} else {
			//Se o projeto não foi avaliado ele exclui normal mas se já foi avaliado o administrador não consegue excluir
			//A não ser que além de excluir o projeto exclua os projetos avaliados tbm.
			projeto.delete();
			
			flash().put("success", "Projeto \""+ projeto.titulo +"\" excluído com sucesso!");
		}
		
		return redirect(routes.Projetos.index());
	}
	
	
	public static Result formularioAvaliacao(Long id) {
		
		
		/*Form<ProjetoForm> form = form(ProjetoForm.class);*/
		Projeto projeto = Projeto.find.byId(id);
		
		/*ProjetoAvaliado projetoAvaliado = ProjetoAvaliado.find.byId(id);*/
		
		if (InformacoesUsuarioHelper.isProjetoAvaliado(id)) {
			flash().put("error", "Você Já avaliou este projeto!");
			return badRequest(views.html.Projetos.visualizar2.render(projeto));
		} else if(InformacoesUsuarioHelper.isCampusIgual(id)==false){
			flash().put("error", "Você não tem permissão para avaliar este projeto!");
			return ok(views.html.Projetos.visualizar.render(projeto));
		}
		
		return ok(views.html.Projetos.formularioAvaliacao.render(form(ProjetoAvaliado.class), projeto));
	}
	
	
	
	public static Result avaliacaoProjeto(Long id) {
		Form<ProjetoAvaliado> form = form(ProjetoAvaliado.class).bindFromRequest();
		Projeto projeto = Projeto.find.byId(id);
		
		if(form.hasErrors()) {
					
			flash().put("error", "Você deve preencher o campo corretamente. Tente novamente!");
			return badRequest(views.html.Projetos.formularioAvaliacao.render(form(ProjetoAvaliado.class), projeto));
		}
		ProjetoAvaliado pAvaliado = form.get();
		
		ProjetoAvaliado projetoAvaliado = new ProjetoAvaliado();
		
		projetoAvaliado.projeto = projeto;
		projetoAvaliado.usuario = InformacoesUsuarioHelper.getUsuarioLogado();
		projetoAvaliado.pontuacaoObtida = pAvaliado.pontuacaoObtida;
		//ProjetoAvaliado projetoAvaliado = form.get();
		//projetoAvaliado.usuario = InformacoesUsuarioHelper.getUsuarioLogado();
		//projetoAvaliado.projeto = Projeto.find.byId(id);
		
		projetoAvaliado.save();
		
		flash().put("success", "Projeto \""+ projeto.titulo +"\" avaliado com sucesso!");
		return redirect(routes.Projetos.index());
	}
	
	
	public static Result meusProjetosAvaliados() {
		List<ProjetoAvaliado> progresso = InformacoesUsuarioHelper.getUsuarioLogado().progresso;
		
		return ok(views.html.Projetos.visualizar3.render(progresso));
	}
	
	public static Result meusProjetos(){
		
		Long autorId = InformacoesUsuarioHelper.getUsuarioLogado().id;
		
		List<Projeto> projetos = Projeto.find.where().eq("autor_id", autorId).findList();//InformacoesUsuarioHelper.getUsuarioLogado().projetos;
		
		
		return ok(views.html.Projetos.visualizar4.render(projetos));
	}
	
	public static Result rankingProjetos(){
		List<Projeto> projetos = Projeto.find.findList();
		
		
		HashMap<Projeto, Integer> pontuacaoProjetos = new HashMap<Projeto, Integer>();
        PontuacaoComparator bvc = new PontuacaoComparator(pontuacaoProjetos);
        TreeMap<Projeto,Integer> rankingProjetos = new TreeMap<Projeto,Integer>(bvc);
		
		for (Projeto projeto : projetos) {
			pontuacaoProjetos.put(projeto, InformacoesUsuarioHelper.getPontuacaoProjeto(projeto.id));
		}

		rankingProjetos.putAll(pontuacaoProjetos);
		
        return ok(views.html.Projetos.ranking.render(rankingProjetos));
		
	}
	
	
}
