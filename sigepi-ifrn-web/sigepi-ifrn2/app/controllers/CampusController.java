package controllers;

import helpers.Seguranca.InformacoesUsuarioHelper;
import helpers.Seguranca.Permissao;

import java.util.Date;
import java.util.List;

import models.Campus;
import models.Edital;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Classe controladora de Campus.
 * 
 * @author Alessandro
 *
 */
public class CampusController extends Controller {

	/**
	 * Lista todos os campus.
	 *
	 * @return
	 */
	public static Result index(){		
		
		List<Campus> campus = Campus.find.findList();
		
		return ok(views.html.Campus.index.render(campus));
	}

	/**
	 * Visualiza um campus específico.
	 *
	 * @param id o id do campus
	 * @return
	 */
	public static Result visualizar(Long id){
		
		Campus campus = Campus.find.byId(id);
		if(campus == null){
			flash().put("error", "O Campus informado não foi encontrado no Sistema.");
			return redirect(routes.CampusController.index());
		}
		return ok(views.html.Campus.visualizar.render(campus));
	}
	/**
	 * Abre o form de cadastro de campus.
	 *
	 * @return
	 */
	@Permissao("Administrador")
	public static Result formulario() {
		return ok(views.html.Campus.formulario.render(form(Campus.class)));
	}

	/**
	 * Insere um novo campus no banco de dados.
	 *
	 * @return
	 */
	@Permissao("Administrador")
	public static Result cadastrar(){

		Form<Campus> form = form(Campus.class).bindFromRequest();
		if(form.hasErrors()){
			flash().put("error", "Você deve preencher o campo corretamente. Tente novamente!");
			return badRequest(views.html.Campus.formulario.render(form));
		}
		
		Campus campus = form.get();
		/*campus.autor = InformacoesUsuarioHelper.getUsuarioLogado();*/				
		campus.save();

		flash().put("success", "Campus \""+campus.nome +"\" Cadastrado com Sucesso!");

		return redirect(routes.CampusController.index());
	}

	/**
	 * Atualiza um campus na base de dados a partir do id.
	 *
	 * @param id o id do campus
	 * @return
	 */
	public static Result editar(Long id) {
		
		Form<Campus> form = form(Campus.class).bindFromRequest();
		Campus campus = Campus.find.byId(id);
		
		if(form.hasErrors()) {
			flash().put("error", "Você deve preencher todos os campos corretamente. Tente novamente!");
			return badRequest(views.html.Campus.formularioEdicao.render((form), campus));
		}
		
		campus.setNome(form.get().nome);
		campus.update();
		
		flash().put("success", "Campus \""+ campus.nome +"\" atualizado com sucesso!");
		return redirect(routes.CampusController.index());
	}

	/**
	 * Abre o form de edição de um campus.
	 * 
	 * @param id o id do campus
	 * @return
	 */
	public static Result formularioEdicao(Long id) {
		Campus campus = Campus.find.byId(id);
		if(campus == null){
			flash().put("error", "O Campus informado não foi encontrado no Sistema.");
			return redirect(routes.CampusController.index());
		}
		return ok(views.html.Campus.formularioEdicao.render(form(Campus.class).fill(campus), campus));
	}

	/**
	 * Exclui um campus da base de dados.
	 *
	 * @param id o id do campus
	 * @return
	 */
	public static Result deletar(Long id){
		Campus campus = Campus.find.byId(id);
		if(campus == null){
			flash().put("error", "O Campus informado não foi encontrado no Sistema.");
		}else if(campus.projetos.size() > 0 || campus.bolsistas.size() > 0 ){
			flash().put("error", "O Campus não pode ser excluído, pois existem outros objetos impedindo a sua exclusão!");
		}else {
			campus.delete();
			flash().put("success", "Campus \""+ campus.nome +"\" excluído com sucesso!");
		}
		
		return redirect(routes.CampusController.index());
	}
}
