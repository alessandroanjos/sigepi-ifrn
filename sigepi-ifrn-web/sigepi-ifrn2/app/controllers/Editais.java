package controllers;

import helpers.Seguranca.InformacoesUsuarioHelper;
import helpers.Seguranca.Permissao;

import java.util.Date;
import java.util.List;

import models.Edital;
import models.Projeto;
import models.ProjetoAvaliado;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Classe controladora de Editais.
 *
 * @author Alessandro
 *
 */
public class Editais extends Controller{

	/**
	 * Lista todos os editais da base de dados.
	 *
	 * @return ok para o render de editais.
	 */
	public static Result index(){
		List<Edital> editais = Edital.find.findList();
		return ok(views.html.Editais.index.render(editais));
	}

	/**
	 * Visualiza um edital especifico.
	 *
	 * @param id o id do edital
	 * @return
	 * @throws Throwable
	 */
	public static Result visualizar(Long id) throws Throwable{
		Edital edital = Edital.find.byId(id);
		if(edital == null){
			flash().put("error", "O Edital informado não foi encontrado no Sistema.");
			return redirect(routes.Editais.index());
		}
		
		return ok(views.html.Editais.visualizar.render(edital));
	}

	/**
	 * Abre um formulário para cadastrar um edital.
	 *
	 * @return ok para o form de Edital.
	 */
	@Permissao("Administrador")
	public static Result formulario() {
		return ok(views.html.Editais.formulario.render(form(Edital.class)));
	}

	/**
	 * Cadastra um novo edital na base de dados.
	 *
	 * @return
	 */
	@Permissao("Administrador")
	public static Result cadastrar(){
		Form<Edital> form = form(Edital.class).bindFromRequest();

		if(form.hasErrors()){
			flash().put("error", "Você deve preencher o campo corretamente. Tente novamente!");
			return badRequest(views.html.Editais.formulario.render(form));
		}

		Edital edital = form.get();
		edital.autor = InformacoesUsuarioHelper.getUsuarioLogado();
		edital.dataCadastro = new Date();

		edital.save();

		flash().put("success", "Edital \""+edital.titulo +"\" Cadastrado com Sucesso!");
		return redirect(routes.Editais.index());
	}

	/**
	 * Permite atualizar um edital na base de dados.
	 *
	 * @param id o id do edital
	 * @return
	 */
	@Permissao("Administrador")
	public static Result editar(Long id) {
		Form<Edital> form = form(Edital.class).bindFromRequest();
		Edital edital = Edital.find.byId(id);

		if(form.hasErrors()) {
			flash().put("error", "Você deve preencher todos os campos corretamente. Tente novamente!");
			return badRequest(views.html.Editais.formularioEdicao.render((form), edital));
		}

		edital.setTitulo(form.get().titulo);
		edital.setDescricao(form.get().descricao);
		edital.setUrl(form.get().url);
		edital.update();

		flash().put("success", "Edital \""+ edital.titulo +"\" atualizado com sucesso!");
		return redirect(routes.Editais.index());
	}

	/**
	 * Abre um formulário para atualização do edital.
	 *
	 * @param id o id do edital
	 * @return
	 */
	@Permissao("Administrador")
	public static Result formularioEdicao(Long id) {
		Edital edital = Edital.find.byId(id);
		if(edital == null){
			flash().put("error", "O Edital informado não foi encontrado no Sistema.");
			return redirect(routes.Editais.index());
		}
		return ok(views.html.Editais.formularioEdicao.render(form(Edital.class).fill(edital), edital));
	}

	/**
	 * Exclui um edital da base de dados.
	 *
	 * @param id o id do edital
	 * @return o redirecionamento para <code>routes.Editais.index()<code>.
	 */
	@Permissao("Administrador")
	public static Result deletar(Long id){
		Edital edital = Edital.find.byId(id);
		List<Projeto> projetos = Projeto.find.where().eq("situacao", -1).findList();

		if(edital == null){
			flash().put("error", "O Edital informado não foi encontrado no Sistema.");
			//caso precise que o edital seja excluído apenas quando todos os projetos tenham sido aprovados ou reprovados
			//utilizaria o código abaixo:

		}else if(projetos.size() > 0 ){
			flash().put("error", "O Edital não pode ser excluído, pois existem projetos em andamento para esse edital!");
		}else {

			//primeiro deletar todos os projetos que foram avaliados
			List<ProjetoAvaliado> projetoAvaliados = ProjetoAvaliado.find.where().findList();
    		for (ProjetoAvaliado p: projetoAvaliados){
    			 p.delete();
    		}

    		//segundo deletar os projetos que são do edital informado.
    		List<Projeto> projetosSubmetidosEdital = Projeto.find.where().eq("edital_id", id).findList(); //todos os projetos submetidos pelo edital que eu quero excluir	
			for (Projeto projeto : projetosSubmetidosEdital) {
				//terceiro eu excluo um por um os projetos do edital
				projeto.delete();
			}

			//quarto eu deleto o edital
			edital.delete();
			flash().put("success", "Edital \""+ edital.titulo +"\" excluído com sucesso!");
		}
		return redirect(routes.Editais.index());
	}
}
