package controllers;

import helpers.Seguranca.InformacoesUsuarioHelper;
import helpers.Seguranca.Permissao;

import java.util.List;
import java.util.Set;

import models.Bolsista;
import models.Campus;
import models.Edital;
import models.Professor;
import models.Projeto;
import models.Usuario;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;



public class Administracao extends Controller {
	
	
	private static final Form<Bolsista> bolsistaForm = form(Bolsista.class);
	
	private static final Form<Edital> editalForm = form(Edital.class);
	
	private static final Form<Campus> campusForm = form(Campus.class);
	
	private static final Form<Professor> userForm = form(Professor.class);

	
    /**
     * Area de incio do Administrador
     */
	@helpers.Seguranca.Permissao("Administrador")
	public static Result index(){
        return ok(views.html.Administrador.index.render());
	}
	
    
/*	public static Result cadastrarEdital(){
		return ok(views.html.Administrador.cadastrarEdital.render());
	}*/
	
    /**
     * Abre a página de gerencia de bolsistas
     */
	@helpers.Seguranca.Permissao("Administrador")
	public static Result gerenciarBolsista(){
		//Passar uma lista de Bolsistas
		List<Bolsista> bolsistas = Bolsista.find.where().findList();
		//Set<Bolsista> bolsistas = Bolsista.findAll();
		List<Projeto> projeto = Projeto.find.findList();
		return ok(views.html.Administrador.gerenciarBolsista.render(bolsistas,projeto));
	}
	
    /**
     * Formulário de Cadastar Bolsista
     */
	@helpers.Seguranca.Permissao("Professor")
	public static Result formularioCadastrarBolsista(){
		List<Projeto> projeto = Projeto.find.findList();
		return ok(views.html.Administrador.formularioCadastrarBolsista.render(bolsistaForm,projeto));//return ok(cadastrarBolsista.render(productForm));
	}
	
    /**
     * Salva o Bolsista no banco de dados
     */
	
	public static Result salvarCadastroBolsista() {
	
		Form<Bolsista> bForm = bolsistaForm.bindFromRequest();
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
		
        //Armazena na memória
		/*
		Bolsista bolsista  = bForm.get();
		Bolsista.add(bolsista);
		flash("success", String.format("Bolsista Adicionado com sucessso!")); 
				return redirect(routes.Administracao.gerenciarBolsista());*/
	}
	
	
	public static Result formularioEdicaoBolsista(Long id){
		Form<Bolsista> bForm = form(Bolsista.class).fill(Bolsista.find.byId(id));
		List<Projeto> projeto = Projeto.find.findList();
		return ok(views.html.Administrador.formularioEdicaoBolsista.render(id, bForm, projeto));
	}
	
	/**
     * Atualiza o Bolsista no banco de dados
     *
     * @param id Id of the computer to edit
     */
    public static Result atualizarBolsista(Long id) {
    	
    	
        Form<Bolsista> bForm = form(Bolsista.class).bindFromRequest();
        Bolsista bolsista = Bolsista.find.byId(id);
        if(bForm.hasErrors()) {
        	flash("error", "Dados inválidos!");
        	List<Projeto> projetos = Projeto.find.findList();
            return badRequest(views.html.Administrador.formularioEdicaoBolsista.render(id, bForm,projetos));
        }
        //Atualiza no BD.
        
        bolsista.setProjeto(Projeto.find.byId((Long.valueOf(bForm.data().get("idProjeto")))));
        bolsista.setNome(bForm.get().nome);
        bolsista.setCpf(bForm.get().cpf);
        bolsista.setEmail(bForm.get().email);
        bolsista.setMatricula(bForm.get().matricula);
        
        
        bolsista.update();
        //bForm.get().update(id);
        flash("success", "Bolsista " + bForm.get().nome + " foi Atualizado(a) com Sucesso!");
        return redirect(routes.Administracao.gerenciarBolsista());
   
    }
    
    /**
     * Deletar o Bolsista
     */
    
    public static Result deletarBolsista(Long id) {
           
        Bolsista bolsista = Bolsista.find.byId(id);
        	
		if (bolsista == null) {
			flash().put("error", "O Bolsista informado não foi encontrado no Sistema.");
		} else {
			bolsista.delete();
						
			flash().put("success", "Bolsista \""+ bolsista.nome +"\" removido(a) com sucesso!");
		}
		
		return redirect(routes.Administracao.gerenciarBolsista());
    }
    
	
    
    
    
    //CRUD Edital
    
    /**
     * Abre a tela de gerenciar editais
     */
    @helpers.Seguranca.Permissao("Administrador")
    public static Result gerenciarEdital(){
    	
    	//Passar uma lista de Bolsistas
    		List<Edital> editais = Edital.find.where().findList();
    	//Set<Bolsista> bolsistas = Bolsista.findAll();
    	   return ok(views.html.Administrador.gerenciarEdital.render(editais));
    }
    
    /**
     * abre o form de cadastrar edital
     */
    @helpers.Seguranca.Permissao("Administrador")
    public static Result formularioCadastrarEdital(){
    	return ok(views.html.Administrador.formularioCadastrarEdital.render(editalForm));//
    }
    
    
    /**
     * Salva o cadastro do edital
     */
    @helpers.Seguranca.Permissao("Administrador")
    public static Result salvarCadastroEdital() {
    	
    	Form<Edital> eForm = editalForm.bindFromRequest();
		if(eForm.hasErrors()){
			flash("error", "Dados inválidos!");
			return badRequest(views.html.Administrador.formularioCadastrarEdital.render(eForm));
		}
		//armazena no BD
		eForm.get().save();
		
        flash("success", "Edital \"" + eForm.get().nome + "\"  foi Cadastrado com Sucesso!");
        return redirect(routes.Administracao.gerenciarEdital());

    }
    
    
    /**
     * form de edição de edital
     */
    @helpers.Seguranca.Permissao("Administrador")
    public static Result formularioEdicaoEdital(Long id){
           
    	Form<Edital> eForm = form(Edital.class).fill(Edital.find.byId(id));
		
		return ok(views.html.Administrador.formularioEdicaoEdital.render(id, eForm));
    }
    
    /**
     * Atualiza o edital
     */
    @helpers.Seguranca.Permissao("Administrador")
    public static Result atualizarEdital(Long id) {
    	Form<Edital> eForm = form(Edital.class).bindFromRequest();
        if(eForm.hasErrors()) {
        	flash("error", "Dados inválidos!");
            return badRequest(views.html.Administrador.formularioEdicaoEdital.render(id, eForm));
        }
        //Atualiza no BD.
        eForm.get().update(id);
        flash("success", "Edital \"" + eForm.get().nome + "\" foi Atualizado com Sucesso!");
        return redirect(routes.Administracao.gerenciarEdital());
    }
    
    
    /**
     * Deleta  o edital
     */
    @helpers.Seguranca.Permissao("Administrador")
    public static Result deletarEdital(Long id) {
    	Edital edital = Edital.find.byId(id);
    	
		if (edital == null) {
			flash().put("error", "O Edital informado não foi encontrado no Sistema.");
		} else {
			edital.delete();
						
			flash().put("success", "Edital \""+ edital.nome +"\" removido com sucesso!");
		}
		
		return redirect(routes.Administracao.gerenciarEdital());
    }
    
    
    
                                                       // CRUD - Gerenciar Campus
    //---------------------------------------------------------------------------------------------------------------------
    
    
    /**
     * Abre a tela de gerenciar campus
     */
    @helpers.Seguranca.Permissao("Administrador")
    public static Result gerenciarCampus(){
    	//Passar uma lista de campus
    	List<Campus> campus = Campus.find.where().findList();
    	
    	return ok(views.html.Administrador.gerenciarCampus.render(campus));	
    }
    
    
    /**
     * abre o form de cadastrar Campus
     */
    @helpers.Seguranca.Permissao("Administrador")
    public static Result formularioCadastrarCampus(){
    	return ok(views.html.Administrador.formularioCadastrarCampus.render(campusForm));
    }
    
    
    /**
     * Salva o cadastro do campus
     */
    @helpers.Seguranca.Permissao("Administrador")
    public static Result salvarCadastroCampus() {
    	Form<Campus> cForm = campusForm.bindFromRequest();
		if(cForm.hasErrors()){
			flash("error", "Dados inválidos!");
			return badRequest(views.html.Administrador.formularioCadastrarCampus.render(cForm));
		}
		//armazena no BD
		cForm.get().save();
		
        flash("success", "Campus \"" + cForm.get().nome + "\"  foi Cadastrado com Sucesso!");
        return redirect(routes.Administracao.gerenciarCampus());
    }
    
    
    
    /**
     * form de edição de campus
     */
    @helpers.Seguranca.Permissao("Administrador")
    public static Result formularioEdicaoCampus(Long id){
        
    	 Form<Campus> cForm = form(Campus.class).fill(Campus.find.byId(id));
		
		return ok(views.html.Administrador.formularioEdicaoCampus.render(id, cForm));
    	
    }
    
    
    /**
     * Atualiza o campus
     */
    @helpers.Seguranca.Permissao("Administrador")
    public static Result atualizarCampus(Long id) {
    	Form<Campus> cForm = form(Campus.class).bindFromRequest();
        if(cForm.hasErrors()) {
        	flash("error", "Dados inválidos!");
            return badRequest(views.html.Administrador.formularioEdicaoCampus.render(id, cForm));
        }
        //Atualiza no BD.
        cForm.get().update(id);
        flash("success", "Edital \"" + cForm.get().nome + "\" foi Atualizado com Sucesso!");
        return redirect(routes.Administracao.gerenciarCampus());
    }
    
    
    
    /**
     * Deleta  o campus
     */
    @helpers.Seguranca.Permissao("Administrador")
    public static Result deletarCampus(Long id) {
	
    	Campus campus = Campus.find.byId(id);
	    	
			if (campus == null) {
				flash().put("error", "O Edital informado não foi encontrado no Sistema.");
			} else {
				campus.delete();
							
				flash().put("success", "Edital \""+ campus.nome +"\" removido(a) com sucesso!");
			}
			
		return redirect(routes.Administracao.gerenciarCampus());
    }
    
    
    ///--------------------------------------------------Cadastrar Professor-----------------------------------------------------
    
    
    /**
     * Formulário de Cadastro de Professor
     */
    
    public static Result formCadastrarProfessor() {
	
       return ok(views.html.Administrador.formCadastrarProfessor.render(form(Usuario.class)));
	}
    
    
    public static Result formularioGestor() {
    	
        return ok(views.html.formularioGestor.render(form(Usuario.class)));
    }
    
    public static Result formularioProfessor() {
    	
        return ok(views.html.formularioProfessor.render(form(Usuario.class)));
    }
    
    
    
    
    /**
     * Salva o cadastro de Professor no banco de dados
     */
    
    public static Result salvarCadastrarProfessor() {
    	
   
    	Form<Usuario> form = form(Usuario.class).bindFromRequest();
    	
    	if(form.hasErrors() || !form.get().senha.equals(form.data().get("confirmacaoSenha"))) {
			flash().put("error", "Você deve preencher todos os campos corretamente. Tente novamente!");
			return badRequest(views.html.Administrador.formCadastrarProfessor.render(form));
		}
    	
    	Usuario professor = form.get();
    	professor.isAtivo = true;
    	professor.isProfessor = true;
    	professor.save();
    	
    	flash().put("success", "Professor \""+ professor.nome +"\" cadastrado(a) com sucesso!");
		return redirect(routes.Administracao.index());
		
    }
    
    
    public static Result salvarCadastrarGestor() {
    	
    	   
    	Form<Usuario> form = form(Usuario.class).bindFromRequest();
    	
    	if(form.hasErrors() || !form.get().senha.equals(form.data().get("confirmacaoSenha"))) {
			flash().put("error", "Você deve preencher todos os campos corretamente. Tente novamente!");
			return badRequest(views.html.formularioGestor.render(form));
		}
    	
    	Usuario gestor  = form.get();
    	gestor.isAtivo  = true;
    	gestor.isGestor = true;
    	gestor.save();
    	
    	flash().put("success", "Gestor \""+ gestor.nome +"\" cadastrado(a) com sucesso!");
		return redirect(routes.Administracao.index());
		
    }
	/*
    	Form<Usuario> form = form(Usuario.class).bindFromRequest();
		
		if(form.hasErrors() || !form.get().senha.equals(form.data().get("confirmacaoSenha"))) {
			flash().put("error", "Você deve preencher todos os campos corretamente. Tente novamente!");
			return badRequest(views.html.Professores.formulario.render(form));
		}
		
		Usuario professor = form.get();
		professor.isAtivo = false;
		professor.isProfessor = true;
		professor.save();
		
		// Envia o email de confirmação de cadastro no sistema!
		RegistroMailer.enviarMensagemRegistro(professor);
		
		flash().put("success", "Professor <strong>\""+ professor.nome +"\"</strong> cadastrado com sucesso!");
		return redirect(routes.Professores.index());
	
    */
    
    //Cadastrar Avaliador
    
    
}
