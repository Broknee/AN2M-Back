package com.an2m.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Prospect {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id;
	private String nom;
	private String numerosiret;
	private String adressepostale;
	private String codepostal;
	private String ville;
	
	public Prospect() {}
	
	public Prospect(String nom, String numero_siret, String adresse_postale, String code_postal, String ville) {
	
		this.nom = nom;
		this.numerosiret = numero_siret;
		this.adressepostale = adresse_postale;
		this.codepostal = code_postal;
		this.ville = ville;
		
	}
	
	@Override
	public String toString() {
		return "\n Nom=" + nom + ", Numero de siret=" + numerosiret + ", Adresse postale=" + adressepostale
				+ ", Code postal=" + codepostal + ", Ville=" + ville;
	}

	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNumerosiret() {
		return numerosiret;
	}
	public void setNumerosiret(String numero_siret) {
		this.numerosiret = numero_siret;
	}

	public String getAdressepostale() {
		return adressepostale;
	}
	public void setAdressepostale(String adresse_postale) {
		this.adressepostale = adresse_postale;
	}

	public String getCodepostal() {
		return codepostal;
	}
	public void setCodepostal(String code_postal) {
		this.codepostal = code_postal;
	}

	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
