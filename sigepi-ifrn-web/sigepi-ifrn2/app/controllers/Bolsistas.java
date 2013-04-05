package controllers;

import helpers.Seguranca.Permissao;

import java.util.List;

import forms.AlterarUsuarioForm;

import models.Bolsista;
import models.Campus;
import models.Curso;
import models.Usuario;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Classe controladora do Crud de Bolsistas.
 * @author Alessandro
 *
 */

public class Bolsistas extends Controller{
	
	/**
	 * Lista todos os bolsistas.
	 * @return
	 */
	@Permissao("Coordenador")
	public static Result listaBolsistas(){
		List<Bolsista> bolsistas  = Bolsista.find.findList();
		return ok(views.html.Bolsistas.listaBolsistas.render(bolsistas));
	}
	
	/**
	 * Abrir um formulário para cadastrar o bolsista.
	 * @return
	 */
	public static Result formulario() {
        List<Campus> campus = Campus.find.findList();
        List<Curso> cursos = Curso.find.findList();
        
		return ok(views.html.Bolsistas.formulario.render(form(Bolsista.class), campus, cursos));
	}
	/**
	 * Insere um bolsista no Banco de dados.
	 * @return
	 */
	public static Result cadastrar(){
		Form<Bolsista> form = form(Bolsista.class).bindFromRequest();
		Long idCampus = Long.valueOf(form.data().get("idCampus"));
		Long idCurso = Long.valueOf(form.data().get("idCurso"));
		
		
		
		if(form.hasErrors()) {
			
			List<Campus> campus = Campus.find.findList();
			List<Curso> cursos = Curso.find.findList();
			
			flash().put("error", "Você deve preencher todos os campos corretamente. Tente novamente!");
			return badRequest(views.html.Bolsistas.formulario.render(form, campus, cursos));
		}
		
		Bolsista bolsista = form.get();
		bolsista.campus = Campus.find.byId(idCampus);
		bolsista.curso = Curso.find.byId(idCurso);
		bolsista.save();

		flash().put("success", "Bolsista \""+ bolsista.nome +"\" cadastrado com sucesso!");
		
		
			return redirect(routes.Bolsistas.listaBolsistas());
	}

	/**
	 * Abre um formulário para editar os dados do bolsista
	 * @param id
	 * @return
	 */
	public static Result formularioEdicao(Long id) {
		Bolsista bolsista = Bolsista.find.byId(id);
		
		List<Campus> campus  = Campus.find.findList();
		List<Curso> cursos = Curso.find.findList();		
				
		return ok(views.html.Bolsistas.formularioEdicao.render(form(Bolsista.class).fill(bolsista), bolsista, campus, cursos));
	}
	
	/**
	 * Atualizar um bolsista no Banco de dados.
	 * @param id
	 * @return
	 */
	public static Result editar(Long id) {
		Form<Bolsista> form = form(Bolsista.class).bindFromRequest();
		Bolsista bolsista = Bolsista.find.byId(id);
		
		if(form.hasErrors()) {
			List<Campus> campus  = Campus.find.findList();
			List<Curso> cursos = Curso.find.findList();
			flash().put("error", "Você deve preencher todos os campos corretamente. Tente novamente!");
			return badRequest(views.html.Bolsistas.formularioEdicao.render(form, bolsista, campus, cursos));
		}
		
		bolsista.setCampus(Campus.find.byId(Long.valueOf(form.data().get("idCampus"))));
		bolsista.setCurso(Curso.find.byId(Long.valueOf(form.data().get("idCurso"))));
		bolsista.setMatricula(form.get().matricula);
		bolsista.setNome(form.get().nome);
		bolsista.update();
		
		flash().put("success", "Bolsista \""+ bolsista.nome +"\" atualizado com sucesso!");
		return redirect(routes.Bolsistas.listaBolsistas());
	}
	
	/**
	 * Exclui um bolsista do banco de dados.
	 * 
	 * @param id
	 * @return
	 */
	public static Result deletar(Long id) {
		Bolsista bolsista = Bolsista.find.byId(id);

		if (bolsista == null) {
			flash().put("error",
					"O Bolsista informado não foi encontrado no Sistema.");
		} else {
			bolsista.delete();
			
			flash().put("success", "Bolsista \"" + bolsista.nome + "\" excluído com sucesso!");
		}

		return redirect(routes.Bolsistas.listaBolsistas());
	}

}
