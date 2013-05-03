package controllers;

import forms.LoginForm;
import forms.ProjetoForm;
import helpers.Pontuacao.PontuacaoComparator;
import helpers.Seguranca.Permissao;
import helpers.Seguranca.InformacoesUsuarioHelper;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.io.IOUtils;

import com.mysql.jdbc.Blob;

import models.Campus;
import models.Curso;
import models.Edital;
import models.Projeto;
import models.ProjetoAvaliado;
import models.Usuario;
import models.Bolsista;

import play.api.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;

public class Projetos extends Controller{


	/**
	 * Método para mostrar a página de início dos novos projetos para o administrador.
	 * @return
	 */
	@Permissao("Administrador")
	public static Result index() {
		Long meuId = InformacoesUsuarioHelper.getUsuarioLogado().id;
		List<Projeto> projetos = Projeto.find.where().eq("usuario_avaliar", meuId).findList();
		List<Usuario> professores = Usuario.find.where().eq("isProfessor", true).findList();
		return ok(views.html.Projetos.index.render(projetos, professores));
	}
	
	/**
	 * Permite visualizar os projetos para avaliar pelo professor.
	 * @return
	 */
	@Permissao("Professor")	
	public static Result projetosAvaliar(){
		Long meuId = InformacoesUsuarioHelper.getUsuarioLogado().id;
		List<Projeto> projetos = Projeto.find.where().eq("usuario_avaliar", meuId).findList();
		List<Usuario> professores = Usuario.find.where().eq("isProfessor", true).findList();

		return ok(views.html.Projetos.visualizarProjetosAvaliar.render(projetos, professores));
	}
	
	/**
	 * Lista todos os projetos para o Administrador verificar.
	 * @return
	 */
	public static Result listaProjetos() {
		List<Projeto> projetos = Projeto.find.findList();
		return ok(views.html.Projetos.listaProjetos.render(projetos));
	}
	
	public static Result visualizar(Long id) {

		try {
			Usuario usuarioLogado = InformacoesUsuarioHelper.getUsuarioLogado();

			if (InformacoesUsuarioHelper.isLogado()) {

				Projeto projeto = Projeto.find.byId(id);
				
				if(projeto == null){
					
					flash().put("error", "O Projeto informado não foi encontrado no Sistema.");
				} else {
					int findRowCount = Projeto.find.where().eq("usuario_avaliar", usuarioLogado.id).findRowCount();
					System.out.println("Visualizar: " + findRowCount);
					Long meuId = InformacoesUsuarioHelper.getUsuarioLogado().id;

					if (InformacoesUsuarioHelper.getUsuarioLogado().id == projeto.autor.id) {
						return ok(views.html.Projetos.visualizar.render(projeto));

					} else if (InformacoesUsuarioHelper.getUsuarioLogado().isProfessor) {

						if (projeto.campus.id != InformacoesUsuarioHelper.getUsuarioLogado().campus.id
								&& 0 != findRowCount && projeto.usuarioAvaliar == meuId) {
							return ok(views.html.Projetos.visualizar2.render(projeto));
						} else {
							flash().put("error", "Acesso Negado. Tente novamente!");
							redirect(routes.Projetos.index());
						}
					} else if (InformacoesUsuarioHelper.getUsuarioLogado().isAdministrador) {

						return ok(views.html.Projetos.visualizar2.render(projeto));

					} else {
						return redirect(routes.Administracao.index());
					}
				}
				return redirect(routes.Projetos.index());

			}
			return redirect(routes.Administracao.index());

		} catch (Exception e) {
			flash().put("info", "Algum problema ocorreu...pedimos desculpas!");
			return redirect(routes.Projetos.index());
		}
	}
	
	/**
	 * Abre o formulário de submissão de projeto.
	 * @return
	 */
	@Permissao("Professor")	
	public static Result formulario() {
		List<Edital> editais = Edital.find.findList();
		List<Curso> cursos = Curso.find.findList();
		
		return ok(views.html.Projetos.formulario.render(form(Projeto.class), editais, cursos ));
	}
	
	/**
	 * Salva um novo projeto de pesquisa no banco de dados.
	 * @return
	 */
	@Permissao("Professor")
	public static Result submeter() {
		
		try {
			Form<Projeto> form = form(Projeto.class).bindFromRequest();
			Long idEdital = Long.valueOf(form.data().get("idEdital"));
			Long idCurso = Long.valueOf(form.data().get("idCurso"));
			
			// Check accept conditions
	        if(!"true".equals(form.field("accept").value())) {
	        	form.reject("accept", "Você deverá aceitar os termos e condições");
	        }

			if (form.hasErrors()) {
				List<Edital> editais = Edital.find.findList();
				List<Curso> cursos = Curso.find.findList();

				flash().put("error",
						"Você deve preencher todos os campos corretamente. Tente novamente!");
				return badRequest(views.html.Projetos.formulario.render(form, editais, cursos));
			}
			
			MultipartFormData body = request().body().asMultipartFormData();
			FilePart article = body.getFile("arquivo");	

			Projeto projeto = form.get();
			projeto.autor = InformacoesUsuarioHelper.getUsuarioLogado();
			projeto.edital = Edital.find.byId(idEdital);
			projeto.campus = InformacoesUsuarioHelper.getUsuarioLogado().campus;
			projeto.areaConhecimento = InformacoesUsuarioHelper
					.getUsuarioLogado().areaConhecimento;
			projeto.grupoPesquisa = InformacoesUsuarioHelper.getUsuarioLogado().grupoPesquisa;
			projeto.usuarioAvaliar = 1L;
			projeto.usuarioAvaliarCPF = "";
			projeto.situacao = -1;
			projeto.curso = Curso.find.byId(idCurso);

			if (article != null) {
				System.out.println("diferente de null");
				File file = article.getFile();

				try {
					byte barr[]= new byte[(int)file.length()];
					//barr=b.getBytes(1,(int)b.length()); 

					 barr= IOUtils.toByteArray(new FileInputStream(file));
					 projeto.arquivo = barr;

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if (article != null) {
				projeto.save();
				
				flash().put("success",	"Projeto \""+ projeto.titulo + "\" submetido com sucesso à Pró-Reitoria de Pesquisa!");
				return redirect(routes.Projetos.meusProjetos());
			} else {
				List<Edital> editais = Edital.find.findList();
				List<Curso> cursos = Curso.find.findList();

				flash().put("error", "Você deve preencher todos os campos corretamente. Tente novamente!");
				return badRequest(views.html.Projetos.formulario.render(form, editais, cursos));
			}

		} catch (Exception e) {
			e.printStackTrace();
			flash().put("error", "Não foi possível fazer a submissão do projeto. \n Talvez alguns dos dados informados já existam na base de dados. Tente Novamente!");
			
			Form<Projeto> form = form(Projeto.class).bindFromRequest();
			List<Edital> editais = Edital.find.findList();
			List<Curso> cursos = Curso.find.findList();
			return badRequest(views.html.Projetos.formulario.render(form, editais, cursos));
		}
	}
	
	/**
	 * Formulario de edição de um projeto peloa Administrador.
	 * @param id o identificador do projeto.
	 * @return
	 */
	@Permissao("Administrador")
	public static Result formularioEdicao(Long id) {
		List<Edital> editais = Edital.find.findList();
		List<Campus> campus  = Campus.find.findList();
		
		Projeto projeto = Projeto.find.byId(id);
		
		return ok(views.html.Projetos.formularioEdicao.render(form(Projeto.class).fill(projeto), editais, campus , projeto));
	}
	
	/**
	 * Atualiza o projeto no banco de dados.
	 * @param id o identificador do projeto.
	 * @return
	 */
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
		projeto.update();
				
		flash().put("success", "Projeto \""+ projeto.titulo +"\" atualizado com sucesso!");
		return redirect(routes.Projetos.index());
	}
	
	/**
	 * Exclui um projeto da base de dados.
	 * @param id o identificador do projeto.
	 * @return
	 */
	@Permissao("Administrador")
	public static Result deletar(Long id) {
		Projeto projeto = Projeto.find.byId(id);
		
		if (projeto == null) {
			flash().put("error", "O Projeto informado não foi encontrado no Sistema.");
		} else if(projeto.progressoProjeto.size() > 0) {
			
			flash().put("error", "O Projeto não pode ser excluído, pois ele está em processo de avaliação!");
		} else {
			//Se o projeto não foi avaliado ele exclui normal mas se já foi avaliado o administrador não consegue excluir
			//A não ser que além de excluir o projeto exclua os projetos avaliados tbm.
			projeto.delete();
			
			flash().put("success", "Projeto \""+ projeto.titulo +"\" excluído com sucesso!");
		}
		
		return redirect(routes.Projetos.listaProjetos());
	}
	
	/**
	 * Abre o formulário de avaliação do projeto.
	 * @param id o id do projeto.
	 * @return
	 */
	public static Result formularioAvaliacao(Long id) {

		Usuario usuarioLogado = InformacoesUsuarioHelper.getUsuarioLogado();

		Projeto proj = Projeto.find.byId(id);

		if (InformacoesUsuarioHelper.isLogado()) {
			if (proj == null) {
				flash().put("error", "O Projeto informado não foi encontrado no Sistema.");
			} else {

				Projeto projeto = Projeto.find.byId(id);
				int findRowCount = Projeto.find.where()
						.eq("usuario_avaliar", usuarioLogado.id).findRowCount();
				System.out.println("form avaliacao: " + findRowCount);
				
				Long meuId = InformacoesUsuarioHelper.getUsuarioLogado().id;
				
				if (InformacoesUsuarioHelper.isProjetoAvaliado(id)) {
					flash().put("error", "Você Já avaliou este projeto!");
					return badRequest(views.html.Projetos.visualizar2
							.render(projeto));

				} else if (InformacoesUsuarioHelper.getUsuarioLogado().isAdministrador) {

					return ok(views.html.Projetos.formularioAvaliacao.render(
							form(ProjetoAvaliado.class), projeto));

				} else if (InformacoesUsuarioHelper.getUsuarioLogado().isProfessor
						&& (projeto.campus.id != InformacoesUsuarioHelper
								.getUsuarioLogado().campus.id)
						&& 0 != findRowCount && projeto.usuarioAvaliar == meuId) {
					// se der true é pq o cara selecionado pelo admin é o que
					// tbm pode avaliar

					return ok(views.html.Projetos.formularioAvaliacao.render(
							form(ProjetoAvaliado.class), projeto));

				} else {
					flash().put("error", "Você não tem permissão para avaliar este projeto!");
					redirect(routes.Projetos.index());
				}
				return ok(views.html.Projetos.visualizar.render(projeto));
			}
			return redirect(routes.Projetos.index());
		}
		return redirect(routes.Sessions.login());
	}
	
	
	/**
	 * Armazena na base de dados os dados informados no formulário de avaliação.
	 * @param id o id do projeto.
	 * @return
	 */
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
		projetoAvaliado.relevanciaTema = pAvaliado.relevanciaTema;
		projetoAvaliado.qualidadeTrabalho = pAvaliado.qualidadeTrabalho;
		projetoAvaliado.originalidade = pAvaliado.originalidade;
		projetoAvaliado.apresentacaoEstrutura = pAvaliado.apresentacaoEstrutura;
		projetoAvaliado.execucaoProjeto = pAvaliado.execucaoProjeto;		

		projetoAvaliado.pontuacaoObtida = (pAvaliado.relevanciaTema + pAvaliado.qualidadeTrabalho + pAvaliado.originalidade 
				+ pAvaliado.apresentacaoEstrutura + pAvaliado.execucaoProjeto);
		projetoAvaliado.comentarios = pAvaliado.comentarios;
		projetoAvaliado.recomendacao = pAvaliado.recomendacao;

		projetoAvaliado.save();

		flash().put("success", "Projeto \""+ projeto.titulo +"\" avaliado com sucesso!");
		return redirect(routes.Projetos.index());
	}
	
	/**
	 * Visualiza os projetos que já foram avaliados.
	 * @return
	 * @throws Exception se o usuário não estiver logado
	 */
	//TODO: Concertar esse método deixar mais enxuto.
	public static Result meusProjetosAvaliados() throws Exception {
		try {
			List<ProjetoAvaliado> progresso = InformacoesUsuarioHelper.getUsuarioLogado().progresso;

			return ok(views.html.Projetos.visualizar3.render(progresso));

		} catch (Exception e) {
			e.printStackTrace();
			return internalServerError("Comportamento Inesperado...");
		}
	}
	
	/**
	 * Visualiza os projetos que o professor submeteu.
	 * @return
	 */
	@Permissao("Professor")
	public static Result meusProjetos(){
		
		Long autorId = InformacoesUsuarioHelper.getUsuarioLogado().id;
		List<Projeto> projetos = Projeto.find.where().eq("autor_id", autorId).findList();//InformacoesUsuarioHelper.getUsuarioLogado().projetos;

		return ok(views.html.Projetos.visualizar4.render(projetos));
	}
	
	/**
	 * Permite que o administrador visualize o Ranking dos projetos.
	 * @return
	 */
	@Permissao("Administrador")
	public static Result rankingProjetos(){
		List<Projeto> projetos = Projeto.find.findList();
		List<Edital> editais = Edital.find.findList();

		HashMap<Projeto, Integer> pontuacaoProjetos = new HashMap<Projeto, Integer>();
        PontuacaoComparator bvc = new PontuacaoComparator(pontuacaoProjetos);
        TreeMap<Projeto,Integer> rankingProjetos = new TreeMap<Projeto,Integer>(bvc);

		for (Projeto projeto : projetos) {
			pontuacaoProjetos.put(projeto, InformacoesUsuarioHelper.getPontuacaoProjeto(projeto.id));
		}

		rankingProjetos.putAll(pontuacaoProjetos);

        return ok(views.html.Projetos.ranking.render(rankingProjetos, editais));

	}
	
	/**
	 * Permite que o administrador visualize o ranking dos projeto pelo edital escolhido.
	 * @param id o id do Edital
	 * @return
	 * @throws Exception
	 */
	@Permissao("Administrador")
	public static Result rankingProjetosEdital(Long id) throws Exception {
		try {
			List<Projeto> projetos = Projeto.find.where().eq("edital_id", id).findList();
			List<Edital> editais = Edital.find.findList();

			HashMap<Projeto, Integer> pontuacaoProjetos = new HashMap<Projeto, Integer>();
			PontuacaoComparator bvc = new PontuacaoComparator(pontuacaoProjetos);
			TreeMap<Projeto, Integer> rankingProjetos = new TreeMap<Projeto, Integer>(bvc);

			for (Projeto projeto : projetos) {
				pontuacaoProjetos.put(projeto, InformacoesUsuarioHelper.getPontuacaoProjeto(projeto.id));
			}

			rankingProjetos.putAll(pontuacaoProjetos);

			return ok(views.html.Projetos.ranking.render(rankingProjetos, editais));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flash().put("info",	"Algum problema ocorreu...pedimos desculpas!");
			return redirect(routes.Projetos.rankingProjetos());
		}
		
	}

	/**
	 * Seleciona um avaliador para o projeto.
	 * @param id o ID do projeto.
	 * @return
	 * @throws Exception
	 */
	@Permissao("Administrador")
	public static Result selecionarAvaliador(Long id) throws Exception {
		
		try {
			Form<Projeto> form = form(Projeto.class).bindFromRequest();
			
			Long idProfessor = Long.valueOf(form.data().get("idProfessores"));
			Projeto projeto = Projeto.find.byId(id);

			String usuarioCPF = Usuario.find.byId(idProfessor).cpf;

			projeto.setUsuarioAvaliar(idProfessor);
			projeto.setUsuarioAvaliarCPF(usuarioCPF);

			projeto.update();

			flash().put("success", "Projeto \""+ projeto.titulo +"\" Selecionado para Avaliação com sucesso!");

			return redirect(routes.Projetos.index());
	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flash().put("error", "Você não selecionou nenhum avaliador para o projeto!");
			return redirect(routes.Projetos.index());
		}
		
	}

	/**
	 * Permite ao Coordenador ou Administrador visualizar os projetos do campus de sua lotação.
	 * @return
	 */
	public static Result visualizarStatusProjetosCampus() {

		if (InformacoesUsuarioHelper.isLogado()) {

			Long meuCampusId = InformacoesUsuarioHelper.getUsuarioLogado().campus.id;
			List<Projeto> projetos = Projeto.find.where().eq("campus_id", meuCampusId).findList();

			if (InformacoesUsuarioHelper.getUsuarioLogado().isCoordenador ||
					InformacoesUsuarioHelper.getUsuarioLogado().isAdministrador) {
				return ok(views.html.Projetos.visualizarStatusProjetosCampus.render(projetos));
			}
			return ok(views.html.Administrador.index.render());
		}
		return redirect(routes.Sessions.login());
	}

	/**
	 * Permite ao administrador aprovar um projeto.
	 * @param id o id do projeto.
	 * @return
	 */
	@Permissao("Administrador")
	public static Result aprovarProjeto(Long id) {
		Projeto projeto = Projeto.find.byId(id);

		if (projeto != null) {

			projeto.setSituacao(1);
			projeto.update();

			flash().put("success","Projeto \"" + projeto.titulo + "\" Aprovado com sucesso!");
			return redirect(routes.Projetos.rankingProjetos());
		} else {
			return redirect(routes.Administracao.index());
		}
	}

	/**
	 * Permite que o administrador visualize os projetos aprovados.
	 * @return
	 */
	@Permissao("Administrador")
	public static Result visualizarProjetosAprovados() {
		List<Projeto> projetos = Projeto.find.where().eq("situacao", true).findList();
		return ok(views.html.Projetos.projetosAprovados.render(projetos));
	}

	/**
	 * Permite que o administrador visualize a opinião dos avaliadores sobre o projeto.
	 * @return
	 */
	@Permissao("Administrador")
	public static Result visualizarOpiniaoAvaliacao() {
		List<ProjetoAvaliado> projetos = ProjetoAvaliado.find.findList();
		return ok(views.html.Projetos.visualizarOpiniaoAvaliacao.render(projetos));
	}

	/**
	 * Permite visualizar os bolsistas do projetos que foram submetidos..
	 * @return
	 */
	public static Result visualizarBolsistasProjetosSubmetidos(){

		List<Projeto> projetosAdmin = Projeto.find.findList();
		if (InformacoesUsuarioHelper.isLogado()) {
			if (InformacoesUsuarioHelper.getUsuarioLogado().isAdministrador ) {
				return ok(views.html.Projetos.visualizarBolsistasProjetosSubmetidos.render(projetosAdmin));

			} else if (InformacoesUsuarioHelper.getUsuarioLogado().isCoordenador || InformacoesUsuarioHelper.getUsuarioLogado().isAdministrador) {
				Long meuCampusId = InformacoesUsuarioHelper.getUsuarioLogado().campus.id;
				List<Projeto> projetos = Projeto.find.where().eq("campus_id", meuCampusId).findList();
				return ok(views.html.Projetos.visualizarBolsistasProjetosSubmetidos.render(projetos));

			}
			return ok(views.html.Administrador.index.render());
		}
		return redirect(routes.Sessions.login());
	}


	/**
	 * Esse método permite fazer o download do arquivo pdf.
	 * @param id o id do projeto.
	 * @return
	 */
	public static Result getDocumento(Long id) {
		Projeto projeto = Projeto.find.byId(id);
		if (projeto != null) {
			response().setContentType("application/pdf");
			response().setHeader("Content-disposition", "attachment; filename="+projeto.id+"-"+projeto.titulo+".pdf");
			response().setHeader("Content-Length", ""+projeto.arquivo.length);
			return ok(projeto.arquivo);
		}
		return badRequest("Projeto inválido!");
	}
}
