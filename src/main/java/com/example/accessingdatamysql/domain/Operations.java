package com.example.accessingdatamysql.domain;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_OPERATION",discriminatorType=DiscriminatorType.STRING,length=2)

public class Operations {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
	protected Date dateOperation;
	protected double montant;
	
	
	public Operations(Double montant, Date date, Comptes comptes) {
	}

	//Getter and setter
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	@Override
	public String toString() {
		return "Operations [id=" + id + ", dateOperation=" + dateOperation + ", montant=" + montant + "]";
	}

	
	
}
