package com.example.accessingdatamysql.domain;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("RT")
public class Retrait extends Operations{

	public Retrait(Double montant, Date date, Comptes comptes) throws Exception {
		super(montant, date, comptes);
		comptes.setSolde(comptes.getSolde() - montant);
	}

	@ManyToOne
	private Comptes comptes;

	@Override
	public String toString() {
		return "Retrait [comptes=" + comptes + ", id=" + id + ", dateOperation=" + dateOperation + ", montant="
				+ montant + "]";
	}

	public Comptes getComptes() {
		return comptes;
	}

	public void setComptes(Comptes comptes) {
		this.comptes = comptes;
	}
	
}
