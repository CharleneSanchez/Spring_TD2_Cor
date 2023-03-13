package com.inti.SpringTest.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Produit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String reference;
	private double prix;
	private double poids;
	
	@ManyToMany
	@JoinTable(name = "Magasin_Produit",
				joinColumns = @JoinColumn(name = "idProduit"),
				inverseJoinColumns = @JoinColumn(name = "idMagasin"))
	List<Magasin> listeMagasin;
	
	public Produit() {
		super();
	}

	public Produit(String nom, String reference, double prix, double poids) {
		super();
		this.nom = nom;
		this.reference = reference;
		this.prix = prix;
		this.poids = poids;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public List<Magasin> getListeMagasin() {
		return listeMagasin;
	}

	public void setListeMagasin(List<Magasin> listeMagasin) {
		this.listeMagasin = listeMagasin;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", reference=" + reference + ", prix=" + prix + ", poids=" + poids
				+ "]";
	}
	
	

}
