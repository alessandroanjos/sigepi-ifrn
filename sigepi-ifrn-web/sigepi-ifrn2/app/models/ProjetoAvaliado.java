package models;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
	@Max(10)
	@Required(message="O campo deve ser preenchido. Minímo 0 Máximo 10")
	public int relevanciaTema;
	

	@Min(0)
	@Max(10)
	@Required(message="O campo deve ser preenchido. Minímo 0 Máximo 10")
	public int qualidadeTrabalho;
	
	@Min(0)
	@Max(10)
	@Required(message="O campo deve ser preenchido. Minímo 0 Máximo 10")
	public int originalidade;
	
	@Min(0)
	@Max(10)
	@Required(message="O campo deve ser preenchido. Minímo 0 Máximo 10")
	public int apresentacaoEstrutura;
	
	@Min(0)
	@Max(10)
	@Required(message="O campo deve ser preenchido. Minímo 0 Máximo 10")
	public int execucaoProjeto;
	
	
	public int pontuacaoObtida;
	
	@Lob
	@Basic(fetch=FetchType.EAGER)
	public String comentarios;
	
	public String recomendacao;
	
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
	
	
	public int getRelevanciaTema() {
		return relevanciaTema;
	}

	public void setRelevanciaTema(int relevanciaTema) {
		this.relevanciaTema = relevanciaTema;
	}

	public int getQualidadeTrabalho() {
		return qualidadeTrabalho;
	}

	public void setQualidadeTrabalho(int qualidadeTrabalho) {
		this.qualidadeTrabalho = qualidadeTrabalho;
	}

	public int getOriginalidade() {
		return originalidade;
	}

	public void setOriginalidade(int originalidade) {
		this.originalidade = originalidade;
	}

	public int getApresentacaoEstrutura() {
		return apresentacaoEstrutura;
	}

	public void setApresentacaoEstrutura(int apresentacaoEstrutura) {
		this.apresentacaoEstrutura = apresentacaoEstrutura;
	}

	public int getExecucaoProjeto() {
		return execucaoProjeto;
	}

	public void setExecucaoProjeto(int execucaoProjeto) {
		this.execucaoProjeto = execucaoProjeto;
	}


	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}


	public String getRecomendacao() {
		return recomendacao;
	}

	public void setRecomendacao(String recomendacao) {
		this.recomendacao = recomendacao;
	}


	public static Finder<Long, ProjetoAvaliado> find = new Finder<Long, ProjetoAvaliado>(Long.class, ProjetoAvaliado.class);

}
