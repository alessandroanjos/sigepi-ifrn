package models;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


import play.data.validation.Constraints.Required;


@Entity
public class Edital {
	@Id
	public Long idEdital;
	@Required (message="O campo Descrição deve ser preenchido")
	public String descricao;
	@Required (message="O campo data deve ser preenchido")
	public Date dataInscricao;
	@Required (message="O campo data deve ser preenchido")
	public Date periodoInscricaoInicial;
	@Required (message="O campo data deve ser preenchido")
	public Date peridoInscricaoFinal;
	
	public Long getIdEdital() {
		return idEdital;
	}
	public void setIdEdital(Long idEdital) {
		this.idEdital = idEdital;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataInscricao() {
		return dataInscricao;
	}
	public void setDataInscricao(Date dataInscricao) {
		this.dataInscricao = dataInscricao;
	}
	public Date getPeriodoInscricaoInicial() {
		return periodoInscricaoInicial;
	}
	public void setPeriodoInscricaoInicial(Date periodoInscricaoInicial) {
		this.periodoInscricaoInicial = periodoInscricaoInicial;
	}
	public Date getPeridoInscricaoFinal() {
		return peridoInscricaoFinal;
	}
	public void setPeridoInscricaoFinal(Date peridoInscricaoFinal) {
		this.peridoInscricaoFinal = peridoInscricaoFinal;
	}


	GregorianCalendar gc = new GregorianCalendar(2009, Calendar.JULY, 15);  
    Date date = gc.getTime();  
   
    public Edital(){
    	
    }
	 
	 
	public Edital(Long idEdital, String descricao, Date dataInscricao, Date periodoInscricaoInicial, Date periodoInscricaoFinal){
		this.idEdital = idEdital;
		this.descricao = descricao;
		this.dataInscricao = dataInscricao;
		this.periodoInscricaoInicial = periodoInscricaoInicial;
		this.peridoInscricaoFinal = periodoInscricaoFinal;
	}
	
		
	private static Set<Edital> editais ;
	static {
		editais = new HashSet<Edital>();
		editais.add(new Edital());
		
	}

}
