package global;

import java.util.ArrayList;
import java.util.Date;

import models.AreaConhecimento;
import models.Campus;
import models.Edital;
import models.Usuario;
import play.*;
import play.api.mvc.RequestHeader;
import play.mvc.*;
import static play.mvc.Results.*;


public class Global extends GlobalSettings{
	
	@Override
	public void onStart(Application app) {
		
		if(AreaConhecimento.find.all().size() == 0){
		   AreaConhecimento area = new AreaConhecimento();
		   area.nome = "Ciência da Computação";
		   area.save();
		   
		   Logger.info("Cadastrando as Áreas de Conhecimento.");
		
		}
		
		if(Campus.find.all().size() ==0){
		  Campus campus = new Campus();
		  campus.nome = "Natal - Central";
		  campus.save();
		  
		  Logger.info("Cadastrando Campus.");
		}
				
		
		if (Usuario.find.all().size() == 0) {
			Usuario administrador = new Usuario();
			administrador.nome = "Admin";
			administrador.email = "admin-sigepi@ifrn.edu.br";
			administrador.login = "admin";
			administrador.senha = "admin";
			administrador.isAtivo = true;
			administrador.isAdministrador = true;
			administrador.areaConhecimento = AreaConhecimento.find.all().get(0);
			
			administrador.save();
			
			Logger.info("Cadastrando o Administrador do Sistema.");
		}
		
		if (Edital.find.all().size() == 0) {
			Edital edital = new Edital();
			edital.titulo = "PIBITI";
			edital.dataCadastro = new Date();
			edital.autor = Usuario.find.all().get(0);
			edital.save();
			
			Logger.info("Cadastrando os Editais.");
		}
		
	}
	
	@Override
	public void onStop(Application app) {
	   Logger.info("Application shutdown...");
	}
	
	// 500 - internal server error
	/*
	public Result onError(Throwable throwable ) {
		
		
      //return redirect(routes.Global.error());
	  //  return InternalServerError(views.html.errorPage.error(throwable)); 
	    
	  }   
 */
	public Result onError(RequestHeader request, Throwable t) {
		  return internalServerError(views.html.global.error.render(t));
	}
	/*
	public Result onError(RequestHeader request, Throwable t){
		//Logger.info("ERROR");
        //return Controller.ok("200");
		return null;
	}
	*/
	/*	
	public Result onHandlerNotFound(RequestHeader request) {
	    return notFound((uri));
	   return notFound(views.html.global.notFound()errors.onHandlerNotFound(request))
	}
	*/
}
