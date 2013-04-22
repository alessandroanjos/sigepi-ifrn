package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.data.validation.Constraints.Max;
import play.data.validation.Constraints.Min;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Projeto extends Model {

	@Id
	public Long id;
	
	@Column(unique=true)
	@Required(message="O campo deve ser preenchido.")
	public String titulo;
	
	@Lob
	@Basic(fetch=FetchType.EAGER)
	@Required(message="O campo deve ser preenchido.")
	public String resumo;
	
	@Lob
	@Basic(fetch=FetchType.EAGER)
	@Required(message="O campo deve ser preenchido.")
	public String introducao;
	
	@Lob
	@Basic(fetch=FetchType.EAGER)
	@Required(message="O campo deve ser preenchido.")
	public String fundamentacaoTeorica;
	
	@Lob
	@Basic(fetch=FetchType.EAGER)
	@Required(message="O campo deve ser preenchido.")
	public String justificativa;
	
	@Lob
	@Basic(fetch=FetchType.EAGER)
	@Required(message="O campo deve ser preenchido.")
	public String objetivos;
	
	@Lob
	@Basic(fetch=FetchType.EAGER)
	@Required(message="O campo deve ser preenchido.")
	public String metodologia;
	
	@Lob
	@Basic(fetch=FetchType.EAGER)
	@Required(message="O campo deve ser preenchido.")
	public String referencias;
	
	@ManyToOne
	public AreaConhecimento areaConhecimento;
	
	@ManyToOne
	public GrupoPesquisa grupoPesquisa;
	
	@ManyToOne
	public Edital edital;
	
	@ManyToOne
	public Usuario autor;
	
	@ManyToOne
	public Campus campus;
	
	@OneToMany
	public List<Bolsista> bolsistas;	
	
	@OneToMany
	public List<ProjetoAvaliado> progressoProjeto;
	
	public Long usuarioAvaliar;
	
	public int situacao;

	@Required(message="O campo deve ser preenchido.")
	public String primeiroBolsistaNome;
	
	@Column(unique=true)
	@Required(message="O campo deve ser preenchido.")
	public String primeiroBolsistaMatricula;
	
	@Min(0)
	@Max(100)
	@Required(message="O campo deve ser preenchido.")
	public int primeiroBolsistaIRA;
	
	@ManyToOne
	public Curso curso;

	public Projeto(){
		
		this.progressoProjeto = new ArrayList<ProjetoAvaliado>();
	}


	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getIntroducao() {
		return introducao;
	}

	public void setIntroducao(String introducao) {
		this.introducao = introducao;
	}

	public String getFundamentacaoTeorica() {
		return fundamentacaoTeorica;
	}

	public void setFundamentacaoTeorica(String fundamentacaoTeorica) {
		this.fundamentacaoTeorica = fundamentacaoTeorica;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public String getObjetivos() {
		return objetivos;
	}

	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}

	public String getMetodologia() {
		return metodologia;
	}

	public void setMetodologia(String metodologia) {
		this.metodologia = metodologia;
	}

	public String getReferencias() {
		return referencias;
	}

	public void setReferencias(String referencias) {
		this.referencias = referencias;
	}

	public Edital getEdital() {
		return edital;
	}

	public void setEdital(Edital edital) {
		this.edital = edital;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
	
	public List<Bolsista> getBolsistas() {
		return bolsistas;
	}

	public void setBolsistas(List<Bolsista> bolsistas) {
		this.bolsistas = bolsistas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Campus getCampus() {
		return campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}

	public List<ProjetoAvaliado> getProgressoProjeto() {
		return progressoProjeto;
	}

	public void setProgressoProjeto(List<ProjetoAvaliado> progressoProjeto) {
		this.progressoProjeto = progressoProjeto;
	}

	public Long getUsuarioAvaliar() {
		return usuarioAvaliar;
	}

	public void setUsuarioAvaliar(Long usuarioAvaliar) {
		this.usuarioAvaliar = usuarioAvaliar;
	}

	public AreaConhecimento getAreaConhecimento() {
		return areaConhecimento;
	}

	public void setAreaConhecimento(AreaConhecimento areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}

	public GrupoPesquisa getGrupoPesquisa() {
		return grupoPesquisa;
	}


	public void setGrupoPesquisa(GrupoPesquisa grupoPesquisa) {
		this.grupoPesquisa = grupoPesquisa;
	}

	public String getPrimeiroBolsistaNome() {
		return primeiroBolsistaNome;
	}


	public void setPrimeiroBolsistaNome(String primeiroBolsistaNome) {
		this.primeiroBolsistaNome = primeiroBolsistaNome;
	}


	public String getPrimeiroBolsistaMatricula() {
		return primeiroBolsistaMatricula;
	}


	public void setPrimeiroBolsistaMatricula(String primeiroBolsistaMatricula) {
		this.primeiroBolsistaMatricula = primeiroBolsistaMatricula;
	}

	public int getPrimeiroBolsistaIRA() {
		return primeiroBolsistaIRA;
	}


	public void setPrimeiroBolsistaIRA(int primeiroBolsistaIRA) {
		this.primeiroBolsistaIRA = primeiroBolsistaIRA;
	}

	public Curso getCurso() {
		return curso;
	}


	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public int getSituacao() {
		return situacao;
	}


	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}

	public static Finder<Long, Projeto> find = new Finder<Long, Projeto>(Long.class, Projeto.class);
	
	@Override
	public String toString(){
		return this.titulo +" - "+ this.getEdital().getTitulo().toString();
	}
}
