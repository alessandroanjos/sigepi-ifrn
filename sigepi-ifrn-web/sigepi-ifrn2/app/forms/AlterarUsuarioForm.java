package forms;

import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.Required;

public class AlterarUsuarioForm {

	@Required(message="O campo deve ser preenchido.")
	public String nome;
	
	@Required(message="O campo deve ser preenchido.")
	@Email(message="Você deve informar um email válido.")
	public String email;
	
	@Required(message="O campo deve ser preenchido.")
	public String cpf;
}
