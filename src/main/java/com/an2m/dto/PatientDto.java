package com.an2m.dto;

import java.sql.Date;
import java.text.SimpleDateFormat;

import jakarta.validation.constraints.NotEmpty;

public class PatientDto {
	
	private int id;
	@NotEmpty
	private String nom;
	@NotEmpty
	private String prenom;
	@NotEmpty
	private String secu;
	@NotEmpty
	private String adresse;
	@NotEmpty
	private String tel;
	@NotEmpty
	private String mail;
	@NotEmpty
	private String prenom_urgent;
	@NotEmpty
	private String tel_urgent;
	@NotEmpty
	private Date date_entree;
	@NotEmpty
	private Date date_sortie;
	@NotEmpty
	private String raison_saijour;
	@NotEmpty
	private String nom_urgent;
	
	public PatientDto(int id, @NotEmpty String nom, @NotEmpty String prenom, @NotEmpty String secu,
			@NotEmpty String adresse, @NotEmpty String tel, @NotEmpty String mail, @NotEmpty String prenom_urgent,
			@NotEmpty String tel_urgent, @NotEmpty @NotEmpty Date date_entree, @NotEmpty @NotEmpty Date date_sortie,
			@NotEmpty String raison_saijour, @NotEmpty String nom_urgent) {
		
		
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.secu = secu;
		this.adresse = adresse;
		this.tel = tel;
		this.mail = mail;
		this.prenom_urgent = prenom_urgent;
		this.tel_urgent = tel_urgent;
		this.date_entree = date_entree;
		this.date_sortie = date_sortie;
		this.raison_saijour = raison_saijour;
		this.nom_urgent = nom_urgent;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSecu() {
		return secu;
	}

	public void setSecu(String secu) {
		this.secu = secu;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPrenom_urgent() {
		return prenom_urgent;
	}

	public void setPrenom_urgent(String prenom_urgent) {
		this.prenom_urgent = prenom_urgent;
	}

	public String getTel_urgent() {
		return tel_urgent;
	}

	public void setTel_urgent(String tel_urgent) {
		this.tel_urgent = tel_urgent;
	}

	public Date getDate_entree() {
		return date_entree;
	}

	public void setDate_entree(Date date_entree) {
		this.date_entree = date_entree;
	}

	public Date getDate_sortie() {
		return date_sortie;
	}

	public void setDate_sortie(Date date_sortie) {
		this.date_sortie = date_sortie;
	}

	public String getRaison_saijour() {
		return raison_saijour;
	}

	public void setRaison_saijour(String raison_saijour) {
		this.raison_saijour = raison_saijour;
	}

	public String getNom_urgent() {
		return nom_urgent;
	}

	public void setNom_urgent(String nom_urgent) {
		this.nom_urgent = nom_urgent;
	}

	@Override
	public String toString() {
		return "PatientDto [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", secu=" + secu + ", adresse="
				+ adresse + ", tel=" + tel + ", mail=" + mail + ", prenom_urgent=" + prenom_urgent + ", tel_urgent="
				+ tel_urgent + ", date_entree=" + date_entree + ", date_sortie=" + date_sortie + ", raison_saijour="
				+ raison_saijour + ", nom_urgent=" + nom_urgent + "]";
	}
	
	
	
	
	
	

}
