package controllers;

import helpers.Seguranca.Permissao;

import java.util.List;

import models.Curso;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Classe controladora responsável pelo Crud de Curso.
 *
 * @author Alessandro
 *
 */
public class Cursos extends Controller{
	
	/**
	 * Método de início irá listas todos os cursos.
	 *
	 * @return as cursos renderizados.
	 */
	public static Result index() {
		List<Curso> cursos = Curso.find.findList();
		return ok(views.html.Cursos.index.render(cursos));
	}

	/**
	 * Visualizar um curso.
	 * @param id
	 * @return um curso.
	 */
	public static Result visualizar(Long id) {
		Curso curso = Curso.find.byId(id);
		if(curso == null){
			flash().put("error", "O Curso informado não foi encontrado no Sistema.");
			return redirect(routes.Cursos.index());
		}
		return ok(views.html.Cursos.visualizar.render(curso));
	}

	/**
	 * Abrir o formulario do cadastro de um novo curso.
	 *
	 * @return um form de Curso.
	 */
	@Permissao("Administrador")
	public static Result formulario() {	
		return ok(views.html.Cursos.formulario.render(form(Curso.class)));
	}

	/**
	 * Cadastra um novo Curso no Banco de dados.
	 *
	 * @return
	 */
	@Permissao("Administrador")
	public static Result cadastrar() {
		Form<Curso> form = form(Curso.class).bindFromRequest();

		if (form.hasErrors()) {
			flash().put("error",
					"Você deve preencher o campo corretamente. Tente novamente!");
			return badRequest(views.html.Cursos.formulario.render(form));
		}

		Curso curso = form.get();
		curso.save();

		flash().put("success", "Curso \"" + curso.nome + "\" Cadastrado com Sucesso!");

		return redirect(routes.Cursos.index());
	}
	
	/**
	 * Atualiza um curso no banco de dados.
	 *
	 * @param id
	 * @return
	 */
	public static Result editar(Long id) {
		Form<Curso> form = form(Curso.class).bindFromRequest();
		Curso curso = Curso.find.byId(id);

		if (form.hasErrors()) {
			flash().put("error",
					"Você deve preencher todos os campos corretamente. Tente novamente!");
			return badRequest(views.html.Cursos.formularioEdicao.render(form.fill(form.get()), curso));
		}

		curso.setNome(form.get().nome);
		curso.update();

		flash().put("success",
				"Curso \"" + curso.nome + "\" atualizado com sucesso!");
		return redirect(routes.Cursos.index());
	}

	/**
	 * Abre um formulário para a atualização de um curso.
	 *
	 * @param id
	 * @return
	 */
	public static Result formularioEdicao(Long id) {
		
		Curso curso = Curso.find.byId(id);
		if(curso == null){
			flash().put("error", "O Curso informado não foi encontrado no Sistema.");
			return redirect(routes.Cursos.index());
		}
		return ok(views.html.Cursos.formularioEdicao.render(form(Curso.class).fill(curso), curso));
	}

	/**
	 * Exlui um curso do Banco de dados.
	 *
	 * @param id
	 * @return
	 */
	public static Result deletar(Long id) {
		Curso curso = Curso.find.byId(id);
		if (curso == null) {
			flash().put("error", "O Curso informado não foi encontrado no Sistema.");

		} else if (curso.bolsistas.size() > 0 || curso.projetos.size() > 0){
			flash().put("error", "O Curso não pode ser excluído, pois existem outros objetos impedindo a sua exclusão!");

		} else {
			curso.delete();
			flash().put("success",	"Curso \"" + curso.nome + "\" excluído com sucesso!");
		}

		return redirect(routes.Cursos.index());
	}

}
