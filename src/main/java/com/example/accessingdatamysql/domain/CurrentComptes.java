package com.example.accessingdatamysql.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("CC")
public class CurrentComptes extends Comptes{

	/**
	 * 
	 */
	private Double decouvert;
	private Double solde;
	private static final long serialVersionUID = 1L;
	@Transient
	public String getDecriminatorValue() {
	    return this.getClass().getAnnotation(DiscriminatorValue.class).value();
	}
	public Double getDecouvert() {
		return decouvert;
	}
	public void setDecouvert(Double decouvert) {
		
		this.decouvert = decouvert;
	}
	public Double getSolde() {
		
		return solde;
	}
	public void setSolde(Double solde) throws Exception {
		if(solde < decouvert) {
			throw new Exception("Exception message");
		}
		else {
			this.solde = solde;
		}
		
		
		
	}
}
