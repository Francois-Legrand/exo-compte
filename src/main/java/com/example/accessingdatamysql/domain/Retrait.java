package com.example.accessingdatamysql.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Retrait extends Operations{

	public	Retrait(Double montant, Date date, Comptes comptes) {
		super(montant, date, comptes);
		comptes.setSolde( montant - comptes.getSolde());
	}

	@ManyToOne
	private Comptes comptes;

	@Override
	public String toString() {
		return "Retrait [comptes=" + comptes + ", id=" + id + ", dateOperation=" + dateOperation + ", montant="
				+ montant + "]";
	}
	
}
