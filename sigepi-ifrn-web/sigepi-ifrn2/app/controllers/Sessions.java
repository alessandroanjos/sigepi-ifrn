package controllers;

import java.security.NoSuchAlgorithmException;

import models.Usuario;

import forms.LoginForm;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Classe responsável pelo controle da autenticação dos usuários.
 * 
 * @author Alessandro
 */

public class Sessions extends Controller {
	
	/**
	 * Metodo para abrir a tela de Login
	 */
	public static Result login() {
	
		return ok(views.html.Sessions.login.render(form(forms.LoginForm.class)));
	}

	/**
	 * Metodo para efetuar o login
	 */
	public static Result efetuarLogin() throws NoSuchAlgorithmException {
		
		Form<LoginForm> loginForm = form(LoginForm.class).bindFromRequest();
		String login = loginForm.field("login").value();
		
		System.out.println("LOGIN:"+login);
		if (loginForm.hasErrors()) {
			flash("error","Login ou Senha Inválida(s). Tente novamente!");
			return redirect(routes.Sessions.login());
		} else {
			Usuario usuario = Usuario.find.where().ilike("login", login).findUnique();
			
			
				session().put("usuarioLogadoID", usuario.id.toString());
				
				if (usuario.isProfessor)
					return redirect(controllers.routes.Professores.index());
				else if(usuario.isAvaliador){
					return redirect(controllers.routes.Avaliadores.index());
				} else if(usuario.isAdministrador){
					return redirect(controllers.routes.Administracao.index());
				} else if(usuario.isGestor){
					return redirect(controllers.routes.Gestores.index());
				}
				else
					return redirect(controllers.routes.Application.index());
			
		}
	}
	
	
	
	/**
	 * Metodo para efetuar o logout
	 */
	public static Result efetuarlogout() {
		
		session().clear();
        flash("success", "Logout realizado com sucesso!");
        return redirect( routes.Sessions.login());
	}
}
