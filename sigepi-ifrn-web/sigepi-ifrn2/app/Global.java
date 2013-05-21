
import java.util.ArrayList;
import java.util.Date;

import models.AreaConhecimento;
import models.Campus;
import models.Curso;
import models.Edital;
import models.GrupoPesquisa;
import models.Usuario;
import play.*;
import play.api.mvc.RequestHeader;
import play.mvc.*;
import static play.mvc.Results.*;

/**
 * 
 * @author Alessandro
 *
 */

public class Global extends GlobalSettings{
	
	@Override
	public void onStart(Application app) {
		
		if(AreaConhecimento.find.all().size() == 0){
		   AreaConhecimento area = new AreaConhecimento();
		   area.nome = "Ciência da Computação";
		   area.save();
		   
		   Logger.info("Cadastrando as Áreas de Conhecimento: " + area.nome);
		
		}
		
		if(Campus.find.all().size() == 0){
		  Campus campus = new Campus();
		  campus.nome = "Natal - Central";
		  campus.save();
		  
		  Logger.info("Cadastrando Campus: "+campus.nome);

		}
		
		
		if (GrupoPesquisa.find.all().size() == 0) {
			GrupoPesquisa grupo = new GrupoPesquisa();
			grupo.nome = "Núcleo de Desenvolvimento de Software";
			grupo.campus = Campus.find.all().get(0);
			grupo.save();

			Logger.info("Cadastrando Grupos de Pesquisa: "+grupo.nome);
		}
		
		if(Curso.find.all().size() == 0){
			Curso curso = new Curso();
			curso.nome = "Tecnologia em Análise e Desenvolvimento de Sistemas";
			curso.save();
			Logger.info("Cadastrando Curso.");
		}
				
		
		if (Usuario.find.all().size() == 0) {
			Usuario administrador = new Usuario();
			administrador.nome = "Admin";
			administrador.email = "admin-sigepi@ifrn.edu.br";
			administrador.cpf = "";
			administrador.login = "admin";
			administrador.senha = "admin";
			administrador.campus = Campus.find.all().get(0);
			administrador.isAtivo = true;
			administrador.isAdministrador = true;
			administrador.areaConhecimento = AreaConhecimento.find.all().get(0);
			
			administrador.save();
			
			Logger.info("Cadastrando o Administrador do Sistema.");
		}
		
		if (Edital.find.all().size() == 0) {
			Edital edital = new Edital();
			edital.titulo = "Edital 01/2013 - PIBITI";
			edital.descricao = "O Instituto Federal de Educação, Ciência e Tecnologia do Rio Grande do Norte - IFRN, através da Pró-Reitoria de Pesquisa e" +
					" Inovação torna público o presente Edital de Convocação para a apresentação de propostas de projetos de " +
					"pesquisa e seleção de estudantes de 3º grau como bolsistas dos Programas Institucionais de Bolsas de Iniciação em Desenvolvimento " +
					"Tecnológico e Inovação – PIBITI, e de Iniciação Científica – PIBIC, do Conselho Nacional de Desenvolvimento Científico e Tecnológico – " +
					"CNPq, que visam estimular estudantes dos cursos de graduação para o desenvolvimento (geração, difusão e transferência) de novas tecnologias e" +
					" inovação e o desenvolvimento científico e tecnológico.";
			edital.dataCadastro = new Date();
			edital.autor = Usuario.find.all().get(0);
			edital.url = "http://www.ifrn.edu.br";
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
	/*
	public Result onError(RequestHeader request, Throwable t) {
		  return internalServerError(views.html.global.error.render(t));
	}
	*/
	/*
	public Result onError(RequestHeader request, Throwable t){
		//Logger.info("ERROR");
        //return Controller.ok("200");
		return null;
	}
	*/
	/*
	public Result onHandlerNotFound(RequestHeader request) {
	   // return notFound((uri));
	  // return notFound(views.html.global.notFound()errors.onHandlerNotFound(request));
		return ok(views.html.global.notFound.render(""));
	}
	*/
	@Override
	public Result onHandlerNotFound(play.mvc.Http.RequestHeader arg0) {
		// TODO Auto-generated method stub
		return super.onHandlerNotFound(arg0);
		
	}
	
	@Override
	public Result onError(play.mvc.Http.RequestHeader arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		return ok(views.html.global.error.render(arg1));
	}
}
