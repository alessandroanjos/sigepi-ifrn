package forms;

import play.data.validation.Constraints.Required;

public class ProjetoForm {

	@Required(message="O campo deve ser preenchido.")
	public String resposta;
}
