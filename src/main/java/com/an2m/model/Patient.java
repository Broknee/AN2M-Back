package com.an2m.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = false)
	private long id;

	@Column(nullable = false, unique = false)
	private String nom;
	@Column(nullable = false, unique = false)
	private String prenom;
	@Column(nullable = false, unique = false)
	private String secu;
	@Column(nullable = false, unique = false)
	private String adresse;
	@Column(nullable = false, unique = false)
	private String tel;
	@Column(nullable = false, unique = false)
	private String mail;
	@Column(nullable = false, unique = false)
	private String nom_urgent;
	@Column(nullable = false, unique = false)
	private String prenom_urgent;
	@Column(nullable = false, unique = false)
	private String tel_urgent;
	@Column(nullable = false, unique = false)
	private Date date_entree;
	@Column(nullable = false, unique = false)
	private Date date_sortie;
	@Column(nullable = false, unique = false)
	private String raison_saijour;
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public String getNom_urgent() {
		return nom_urgent;
	}
	public void setNom_urgent(String nom_urgent) {
		this.nom_urgent = nom_urgent;
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

}
