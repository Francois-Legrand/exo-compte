package com.example.accessingdatamysql.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("CE")
public class EpargneComptes extends Comptes{

	/**
	 * 
	 */
	private int tauxInteret;
	private static final long serialVersionUID = 1L;
	@Transient
	public String getDecriminatorValue() {
	    return this.getClass().getAnnotation(DiscriminatorValue.class).value();
	}
	public int getTauxInteret() {
		return tauxInteret;
	}
	public void setTauxInteret(int tauxInteret) {
		this.tauxInteret = tauxInteret;
	}
	
}
