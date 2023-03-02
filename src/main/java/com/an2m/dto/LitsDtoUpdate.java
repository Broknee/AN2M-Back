package com.an2m.dto;


import jakarta.validation.constraints.NotEmpty;

public class LitsDtoUpdate {
	
	
	private int id;
	
	@NotEmpty
	private String status;
	@NotEmpty
	private int chambre_id;
	@NotEmpty
	private int patient_id;
	
	public LitsDtoUpdate() {
	}

	public LitsDtoUpdate(int id, @NotEmpty String status, @NotEmpty int chambre_id, @NotEmpty int patient_id) {
		this.id = id;
		this.status = status;
		this.chambre_id = chambre_id;
		this.patient_id = patient_id;
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

	public int getChambre_id() {
		return chambre_id;
	}

	public void setChambre_id(int chambre_id) {
		this.chambre_id = chambre_id;
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	@Override
	public String toString() {
		return "LitsDtoUpdate [id=" + id + ", status=" + status + ", chambre_id=" + chambre_id + ", patient_id="
				+ patient_id + "]";
	}
	
	
	
	

	
	
}