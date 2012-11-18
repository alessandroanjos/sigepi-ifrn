package controllers;

import java.util.List;
import java.util.Set;

import models.Bolsista;
import models.Edital;
import models.Usuario;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;



public class Administracao extends Controller {
	
	private static final Form<Bolsista> bolsistaForm = form(Bolsista.class);
	
	private static final Form<Edital> editalForm = form(Edital.class);

	
	public static Result index(){
        return ok(views.html.Administrador.index.render());
	}
	
	public static Result cadastrarEdital(){
		return ok(views.html.Administrador.cadastrarEdital.render());
	}
	
	public static Result gerenciarBolsista(){
		//Passar uma lista de Bolsistas
		List<Bolsista> bolsistas = Bolsista.find.where().findList();
		//Set<Bolsista> bolsistas = Bolsista.findAll();
		return ok(views.html.Administrador.gerenciarBolsista.render(bolsistas));
	}
	
	public static Result formularioCadastrarBolsista(){
		return ok(views.html.Administrador.formularioCadastrarBolsista.render(bolsistaForm));//return ok(cadastrarBolsista.render(productForm));
	}
	
	public static Result salvarCadastroBolsista() {
		
		Form<Bolsista> bForm = bolsistaForm.bindFromRequest();
		if(bForm.hasErrors()){
			flash("error", "Dados inválidos!");
			return badRequest(views.html.Administrador.formularioCadastrarBolsista.render(bForm));
		}
		//armazena no BD
		bForm.get().save();
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
		
		return ok(views.html.Administrador.formularioEdicaoBolsista.render(id, bForm));
	}
	
	/**
     * Handle the 'edit form' submission 
     *
     * @param id Id of the computer to edit
     */
    public static Result atualizarBolsista(Long id) {
        Form<Bolsista> bForm = form(Bolsista.class).bindFromRequest();
        if(bForm.hasErrors()) {
            return badRequest(views.html.Administrador.formularioEdicaoBolsista.render(id, bForm));
        }
        //Atualiza no BD.
        bForm.get().update(id);
        flash("success", "Bolsista " + bForm.get().nome + " foi Atualizado(a) com Sucesso!");
        return redirect(routes.Administracao.gerenciarBolsista());
   
    }
    
    /**
     * Handle computer deletion
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
    
    public static Result gerenciarEdital(){
    	
    	//Passar uma lista de Bolsistas
    		List<Edital> editais = Edital.find.where().findList();
    	//Set<Bolsista> bolsistas = Bolsista.findAll();
    	   return ok(views.html.Administrador.gerenciarEdital.render(editais));
    }
    
    public static Result formularioCadastrarEdital(){
    	return ok(views.html.Administrador.formularioCadastrarEdital.render(editalForm));//
    }
    
    public static Result salvarCadastroEdital() {
    	
    	Form<Edital> eForm = editalForm.bindFromRequest();
		if(eForm.hasErrors()){
			flash("error", "Dados inválidos!");
			return badRequest(views.html.Administrador.formularioCadastrarEdital.render(eForm));
		}
		//armazena no BD
		eForm.get().save();
		
        flash("success", "Edital \"" + eForm.get().nome + "\"  foi Cadastrado(a) com Sucesso!");
        return redirect(routes.Administracao.gerenciarEdital());

    }
    
    public static Result formularioEdicaoEdital(Long id){
           
    	Form<Edital> eForm = form(Edital.class).fill(Edital.find.byId(id));
		
		return ok(views.html.Administrador.formularioEdicaoEdital.render(id, eForm));
    }
    
    public static Result atualizarEdital(Long id) {
    	Form<Edital> eForm = form(Edital.class).bindFromRequest();
        if(eForm.hasErrors()) {
            return badRequest(views.html.Administrador.formularioEdicaoEdital.render(id, eForm));
        }
        //Atualiza no BD.
        eForm.get().update(id);
        flash("success", "Edital \"" + eForm.get().nome + "\" foi Atualizado(a) com Sucesso!");
        return redirect(routes.Administracao.gerenciarEdital());
    }
    
    public static Result deletarEdital(Long id) {
    	Edital edital = Edital.find.byId(id);
    	
		if (edital == null) {
			flash().put("error", "O Edital informado não foi encontrado no Sistema.");
		} else {
			edital.delete();
						
			flash().put("success", "Edital \""+ edital.nome +"\" removido(a) com sucesso!");
		}
		
		return redirect(routes.Administracao.gerenciarEdital());
    }
}
