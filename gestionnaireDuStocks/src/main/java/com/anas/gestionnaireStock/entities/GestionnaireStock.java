package com.anas.gestionnaireStock.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class GestionnaireStock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Nom;
	private int Stock;
	private Date Daterecu;
	private double Taxe;
	private int jours;
	
	public GestionnaireStock() 
	{
		super();
		
	}
	
	public GestionnaireStock( String nom,Date Daterecu, int stock,  double taxe, int jours) {
		super();
		
		Nom = nom;
		Stock = stock;
		this.Daterecu= Daterecu;
		Taxe = taxe;
		this.jours = jours;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public int getStock() {
		return Stock;
	}
	public void setStock(int stock) {
		Stock = stock;
	}
	
	public double getTaxe() {
		return Taxe;
	}
	public void setTaxe(double taxe) {
		Taxe = taxe;
	}
	public int getJours() {
		return jours;
	}
	public void setJours(int jours) {
		this.jours = jours;
	}

	public Date getDaterecu() {
		return Daterecu;
	}

	public void setDaterecu(Date daterecu) {
		Daterecu = daterecu;
	}

	@Override
	public String toString() {
		return "GestionnaireStock [id=" + id + ", Nom=" + Nom + ", Stock=" + Stock + ", Daterecu=" + Daterecu
				+ ", Taxe=" + Taxe + ", jours=" + jours + "]";
	}
	
	

}
