package controllers;

import java.security.NoSuchAlgorithmException;

import models.Avaliador;

import form.LoginForm;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Sessions extends Controller{

	public static Result login() {
		return ok(views.html.Sessions.login.render(form(LoginForm.class)));
	}
	
	public static Result esqueciSenha(){
		return ok(views.html.Sessions.esqueciSenha.render(form(Avaliador.class)));
	}
	
	public static Result solicitarRedefinicaoSenha() {
		return TODO;
	}
	
	public static Result efetuarLogin() throws NoSuchAlgorithmException {
		Form<LoginForm> loginForm = form(LoginForm.class);
        // VALOR ANTERIOR ERA: Form<LoginForm> loginForm = form(LoginForm.class).bindFromRequest();
		String login = loginForm.field("login").value();
		
	
		if (loginForm.hasErrors()) {
			flash("error","Login ou Senha Inválida(s). Tente novamente!");
			return redirect(routes.Sessions.login());
		} else {
			/*
			 * Ver com Lucena como ageitar esse -> session("login", loginForm.get().login);
			 */
			  //session("login", loginForm.get().login);
	            return redirect( routes.Avaliadores.index() );
			/*
			Avaliador usuario = Avaliador.find.where().ilike("login", login).findUnique();
			
			if (!usuario.isAtivo) {
				flash("error",
						"Você precisa ativar sua conta para poder acessar o sistema. " +
						"<a href=\""+ controllers.routes.Sessions.login().absoluteURL(request()) + "\">Clique AQUI para ativar sua conta!</a>");
				
				 //O VALOR ANTERIOR ERA : "<a href=\""+ controllers.routes.Sessions.ativarConta(usuario.email).absoluteURL(request()) + "\">Clique AQUI para ativar sua conta!</a>");
				 
				return redirect(controllers.routes.Application.index());
			} else {
				session().put("usuarioLogadoID", usuario.id.toString());
				
				if (usuario.isProfessor)
					return redirect(controllers.routes.Administracao.index());
				else
					return redirect(controllers.routes.Application.index());
			}
			*/
		}
	}
	
	public static Result efetuarlogout() {
		session().clear();
        flash("success", "Você está desconectado.");
        return redirect(
            routes.Sessions.login());
    }
}
