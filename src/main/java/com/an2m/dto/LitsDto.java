package com.an2m.dto;

import com.an2m.model.Chambres;
import com.an2m.model.Patient;

import jakarta.validation.constraints.NotEmpty;

public class LitsDto {
	
	private int id;
	
	@NotEmpty
	private String status;
	@NotEmpty
	private Chambres chambre;
	@NotEmpty
	private Patient patient;
	
	
	
	public LitsDto() {
	}
	public LitsDto(int id, @NotEmpty String status,  @NotEmpty Chambres chambre, @NotEmpty Patient patient) {

		this.id = id;
		this.status = status;
		this.chambre = chambre;
		this.patient = patient;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Chambres getChambre() {
		return chambre;
	}
	public void setChambre(Chambres chambre2) {
		this.chambre = chambre2;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patientDto) {
		this.patient = patientDto;
	}
	@Override
	public String toString() {
		return "LitsDto [id=" + id + ", status=" + status + ", chambre=" + chambre + ", patient=" + patient + "]";
	}
	
	
	
	
	
	
	
	
	
}

