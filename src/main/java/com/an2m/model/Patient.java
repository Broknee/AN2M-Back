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
	private int id;

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
	private String raison_sejour;

}
