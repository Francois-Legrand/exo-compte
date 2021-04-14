package com.example.accessingdatamysql.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Versement extends Operations{
	
	
	public Versement(Double montant, Date date, Comptes comptes) {
		super(montant, date, comptes);
		comptes.setSolde( montant + comptes.getSolde());
	}

	@ManyToOne
	private Comptes comptes;

	
	
	public Comptes getComptes() {
		return comptes;
	}



	public void setComptes(Comptes comptes) {
		this.comptes = comptes;
	}



	@Override
	public String toString() {
		return "Versement [comptes=" + comptes + ", id=" + id + ", dateOperation=" + dateOperation + ", montant="
				+ montant + "]";
	}
	
	
}
