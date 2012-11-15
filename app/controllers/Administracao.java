package controllers;

import java.util.Set;

import models.Bolsista;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;



public class Administracao extends Controller {
	
	private static final Form<Bolsista> bolsistaForm = form(Bolsista.class);

	public static Result index(){
        return ok(views.html.Administrador.index.render());
	}
	
	public static Result cadastrarEdital(){
		return ok(views.html.Administrador.cadastrarEdital.render());
	}
	
	public static Result gerenciarBolsista(){
		
		Set<Bolsista> bolsistas = Bolsista.findAll();
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
		Bolsista bolsista  = bForm.get();
		Bolsista.add(bolsista);
		flash("success", String.format("Bolsista Adicionado com sucessso!")); 
				return redirect(routes.Administracao.gerenciarBolsista());
	}
	
}
