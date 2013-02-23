package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints.Max;
import play.data.validation.Constraints.Min;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class ProjetoAvaliado extends Model {
	
	@Id
	public int id;
	
	@Min(0)
	@Max(100)
	@Required(message="O campo deve ser preenchido. Minímo 0 Máximo 100")
	public int pontuacaoObtida;
	
    @ManyToOne
	public Usuario usuario;
	
	@ManyToOne
	public Projeto projeto;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPontuacaoObtida() {
		return pontuacaoObtida;
	}

	public void setPontuacaoObtida(int pontuacaoObtida) {
		this.pontuacaoObtida = pontuacaoObtida;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	
	
	public static Finder<Long, ProjetoAvaliado> find = new Finder<Long, ProjetoAvaliado>(Long.class, ProjetoAvaliado.class);

}
