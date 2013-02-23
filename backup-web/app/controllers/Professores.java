package controllers;


import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import java.util.List;
import java.util.Date;
import models.Campus;
import models.Edital;
import models.Projeto;




public class Professores extends Controller{
	
	private static final Form<Projeto> projetoForm = form(Projeto.class);

    /**
     * Inicio da área do professro
     */
	@helpers.Seguranca.Permissao("Professor")
	public static Result index(){
		return ok(views.html.Professor.index.render());
	}
	
    /**
     * Formulário de de submeter projeto 
     */
	
	@helpers.Seguranca.Permissao("Professor")
	public static Result submeterProjeto(){
		
		List<Edital> edital = Edital.find.findList();
		List<Projeto> projeto = Projeto.find.findList();
		
		return ok(views.html.Professor.submeterProjeto.render(form(Projeto.class),edital,projeto));
	}
	
	
    /**
     * Envia os dados do projeto para avaliação
     */
	@helpers.Seguranca.Permissao("Professor")
	public static Result enviarProjetoAvaliacao() {
		
		return TODO;
		/*
		Form<Projeto> form = form(Exercicio.class).bindFromRequest();
		Long idCurso = Long.valueOf(form.data().get("idCurso"));
		
		if(form.hasErrors()) {
			List<Curso> cursos = Curso.find.findList();
			
			flash().put("error", "Você deve preencher todos os campos corretamente. Tente novamente!");
			return badRequest(views.html.Exercicios.formulario.render(form, cursos));
		}
		
		Exercicio exercicio = form.get();
		exercicio.autor = InformacoesUsuarioHelper.getUsuarioLogado();
		exercicio.curso = Curso.find.byId(idCurso);
		exercicio.save();
		
		flash().put("success", "Exercício <strong>\""+ exercicio.titulo +"\"</strong> cadastrado com sucesso!");
		return redirect(routes.Exercicios.index());
		*/
	}
	
    /**
     * 
     */
	
	public static Result curriculo(){
	    return ok(views.html.Professor.curriculo.render());
	}
	
	
    /**
     * 
     */
	
	public static Result atualizarCurriculo(){
		return ok(views.html.Professor.atualizarCurriculo.render());
	}
	
    /**
     *  tela de gerencia do projeto
     */
	@helpers.Seguranca.Permissao("Professor")
	public static Result gerenciarProjeto(){
		List<Projeto> projetos = Projeto.find.where().findList();
		List<Campus> campus  = Campus.find.where().findList();
		
		return ok(views.html.Professor.gerenciarProjeto.render(projetos, campus));
	
		
	}
    /**
     * Abre o formulário de cadastrar o projeto
     */
	@helpers.Seguranca.Permissao("Professor")
	public static Result formularioCadastrarProjeto(){	
		//Lista de Campus
		List<Campus> campus = Campus.find.findList();		
		return ok(views.html.Professor.formularioCadastrarProjeto.render(projetoForm, campus));
	}
	
    /**
     * Inserir o projeto no Banco de Dados 
     */
	@helpers.Seguranca.Permissao("Professor")
	public static Result salvarCadastroProjeto() {
		/*
		 * Form<Bolsista> bForm = bolsistaForm.bindFromRequest();
		Long idProjeto = Long.valueOf(bForm.data().get("idProjeto"));
		
		if(bForm.hasErrors()){
			flash("error", "Dados inválidos!");
			
			List<Projeto> projeto = Projeto.find.findList();
			return badRequest(views.html.Administrador.formularioCadastrarBolsista.render(bForm,projeto));
		}
		//armazena no BD
		//bForm.get().save();
		
		Bolsista bol = bForm.get();
		
		
		bol.projeto = Projeto.find.byId(idProjeto);
		bol.save();
		System.out.println("BOLSISTA-PROJETO"+bol.projeto.nome);
		
        flash("success", "Bolsista \"" + bForm.get().nome + "\" foi Cadastrado(a) com Sucesso!");
        return redirect(routes.Administracao.gerenciarBolsista());
		 */
		Form<Projeto> pForm = projetoForm.bindFromRequest();
		Long idCampus = Long.valueOf(pForm.data().get("idCampus"));
		
		
		if(pForm.hasErrors()){
			flash("error", "Dados inválidos!");
			
			List<Campus> campus = Campus.find.findList();
			return badRequest(views.html.Professor.formularioCadastrarProjeto.render(pForm,campus));
		}
		//armazena no BD
         
        Projeto projeto = pForm.get();
	    projeto.campus = Campus.find.byId(idCampus);
		projeto.dataCadastro = new Date();
		projeto.save();
		System.out.println("PROJETO-CAMPUS"+projeto.campus);
		
        flash("success", "Projeto \"" + pForm.get().nome + "\" foi Cadastrado com Sucesso!");
        return redirect(routes.Professores.gerenciarProjeto());
		
		
		/*
		 * 
		 Projeto projeto = pForm.get();
		
		//colocar ao invés de Projeto - colocar Campus.
		projeto.nome = Projeto.find.byId(idProjeto);
		projeto.dataCadastro = new Date();
		bol.save();
		System.out.println("BOLSISTA-PROJETO"+bol.projeto.nome);
		
        flash("success", "Bolsista \"" + bForm.get().nome + "\" foi Cadastrado(a) com Sucesso!");
        return redirect(routes.Administracao.gerenciarBolsista());
		
		*/
		/*
		pForm.get().save();
        flash("success", "Projeto \"" + pForm.get().nome + "\" foi Cadastrado(a) com Sucesso!");
        return redirect(routes.Professores.gerenciarProjeto());
		*/
	}
    /**
     * Abrir o formulário de edição do projeto
     */
	@helpers.Seguranca.Permissao("Professor")
	public static Result formularioEdicaoProjeto(Long id){
		Form<Projeto> pForm = form(Projeto.class).fill(Projeto.find.byId(id));
		List<Campus> campus = Campus.find.findList();
		return ok(views.html.Professor.formularioEdicaoProjeto.render(id, pForm, campus));
	}
	
    /**
     * Atualizar o projeto
     */
	@helpers.Seguranca.Permissao("Professor")
    public static Result update(Long id) {
        Form<Projeto> pForm = form(Projeto.class).bindFromRequest();
        if(pForm.hasErrors()) {
        	flash("error", "Dados inválidos!");
        	List<Campus> campus = Campus.find.findList();
        	
            return badRequest(views.html.Professor.formularioEdicaoProjeto.render(id, pForm, campus));
        }
        //Atualiza no BD.
        pForm.get().update(id);
        flash("success", "Projeto \"" + pForm.get().nome + "\" foi Atualizado(a) com Sucesso!");
        return redirect(routes.Professores.gerenciarProjeto());
   
    }
    
    /**
     * Deletar o projeto
     */
    @helpers.Seguranca.Permissao("Professor")
    public static Result deletarProjeto(Long id) {
           
        Projeto projeto = Projeto.find.byId(id);
        	
		if (projeto == null) {
			flash().put("error", "O projeto não foi encontrado no sistema.");
		} else {
			projeto.delete();
						
			flash().put("success", "Projeto \""+ projeto.nome +"\" removido(a) com sucesso!");
		}
	
		return redirect(routes.Professores.gerenciarProjeto());
    }
    
    public static Result exibirDadosCadastrados(){
    	return TODO;
    }
}
