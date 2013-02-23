package helpers.Seguranca;


import java.util.Iterator;
import java.util.List;

import play.mvc.Controller;
import models.Projeto;
import models.ProjetoAvaliado;
import models.Usuario;


public class InformacoesUsuarioHelper extends Controller {

	
	public static Usuario getUsuarioLogado() {
		Long idUsuario = Long.parseLong(session("usuarioLogadoID"));
		
		return Usuario.find.byId(idUsuario);
	}

	public static Boolean isLogado() {
		return session().get("usuarioLogadoID") == null ? false : true;
	}
	
	public static Boolean isProjetoAvaliado(Long idProjeto) {
		Usuario usuarioLogado = getUsuarioLogado();
		
		int findRowCount = ProjetoAvaliado.find.where()
			.eq("usuario_id", usuarioLogado.id)
			.eq("projeto_id", idProjeto).findRowCount();
		
		if (findRowCount != 0) {
			return true;
		}
		
		return false;
	}
	
	public static Boolean isCampusIgual(Long idProjeto) {
   
		/*Long campusId = InformacoesUsuarioHelper.getUsuarioLogado().campus.id;
		//Long autorId = InformacoesUsuarioHelper.getUsuarioLogado().id;
		
		//Projeto.find.where().eq("campus_id", campusId).findList();
		List<Projeto> projetos = Projeto.find.where().eq("campus_id", campusId).findList();
		
		return projetos;*/
		
		//pegando o id do campus do usuario q está logado atualmente
		//Long campusId = InformacoesUsuarioHelper.getUsuarioLogado().campus.id;

		Projeto projeto = Projeto.find.byId(idProjeto);

		if (InformacoesUsuarioHelper.getUsuarioLogado().isAdministrador
				|| InformacoesUsuarioHelper.getUsuarioLogado().isAvaliador
				|| InformacoesUsuarioHelper.getUsuarioLogado().isGestor) {

			// listo os projetos q batem com o mesmo resultado de campus iguais.
			/*
			 * List<Projeto> projetos = Projeto.find.where() .eq("campus_id",
			 * campusId).findList();
			 */
			if (projeto.campus.id == InformacoesUsuarioHelper
					.getUsuarioLogado().campus.id) {

				return true;
			}
		} else {
			flash().put("error", "Você não tem permissão para ver os projetos!");
			// redirect(routes.Sessions.login());
			return false;
		}
		return false;
		
		//List<Projeto> projetos = Projeto.find.where().eq("autor_id", autorId).findList();
	}
	
	public static ProjetoAvaliado getProjetoAvaliado(Long idProjeto) {
		Usuario usuarioLogado = getUsuarioLogado();
		
		ProjetoAvaliado projetoAvaliado = ProjetoAvaliado.find.where()
			.eq("usuario_id", usuarioLogado.id)
			.eq("projeto_id", idProjeto).findUnique();
		
		return projetoAvaliado;
	}
	
	
	public static int getPontuacaoUsuario() {
		Usuario usuarioLogado = getUsuarioLogado();
		int pontuacao = 0;
		
		for (ProjetoAvaliado projetoAvaliado : usuarioLogado.progresso) {
			pontuacao += projetoAvaliado.pontuacaoObtida;
		}
		
		return pontuacao;
	}

	public static int getPontuacaoUsuario(Long id) {
		Usuario usuario = Usuario.find.byId(id);
		
		int pontuacao = 0;
		
			for(ProjetoAvaliado projetoAvaliado : usuario.progresso){
							
			     pontuacao += projetoAvaliado.pontuacaoObtida;
			     
			}
		
		return pontuacao;
	}
	
	//não sei se dá certo ainda
	public static int getPontuacaoProjeto() {
		Projeto projeto = (Projeto) getUsuarioLogado().projetos;
		int pontuacao = 0;
		
		for (ProjetoAvaliado projetoAvaliado : projeto.progressoProjeto) {
			pontuacao += projetoAvaliado.pontuacaoObtida;
		}
		
		return pontuacao;
	}
	
	
	
	public static int getPontuacaoProjeto(Long id) {

		Projeto projeto = Projeto.find.byId(id);

		int pontuacao = 0;

		for (ProjetoAvaliado projetoAvaliado : projeto.progressoProjeto) {

			pontuacao += projetoAvaliado.pontuacaoObtida;
		}

		return pontuacao;
	}
	
	public static Boolean isAvaliadorCampusIgual(Long id) {
		Usuario usuario = Usuario.find.byId(id);
		
		if(usuario.campus.id == InformacoesUsuarioHelper.getUsuarioLogado().campus.id){
			
			return true;
		}
		else 			
			return false;	
			
	}
}
