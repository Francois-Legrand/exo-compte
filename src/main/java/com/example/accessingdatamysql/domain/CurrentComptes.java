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
	private int decouvert; 
	private static final long serialVersionUID = 1L;
	@Transient
	public String getDecriminatorValue() {
	    return this.getClass().getAnnotation(DiscriminatorValue.class).value();
	}
	public int getDecouvert() {
		return decouvert;
	}
	public void setDecouvert(int decouvert) {
		this.decouvert = decouvert;
	}
	
}
