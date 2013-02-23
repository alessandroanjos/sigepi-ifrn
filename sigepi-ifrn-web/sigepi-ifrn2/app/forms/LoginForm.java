package forms;

import java.security.NoSuchAlgorithmException;

import models.Usuario;


public class LoginForm {

	public String login;
	public String senha;
	
	
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String validate() throws NoSuchAlgorithmException {
        if (Usuario.autenticar(login, senha) == null) {
        	return "Login ou Senha Inválida(s). Tente novamente!";
        }
        
        return null;
    }
}
