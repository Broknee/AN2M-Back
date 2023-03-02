package com.an2m.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="suivi_patient")
public class Suivi_patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = false)
	private int id;

	@Column(nullable = false, unique = false)
	private String com;
	

	@ManyToOne
	@JoinColumn( name="users_id" )
	private User user;
	

	@ManyToOne
	@JoinColumn( name="patient_id" )
	private Patient patient;
	

}
