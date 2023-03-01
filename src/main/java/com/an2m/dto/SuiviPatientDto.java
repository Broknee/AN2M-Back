package com.an2m.dto;

import jakarta.validation.constraints.NotEmpty;

public class SuiviPatientDto {
	
	

	private int id;

	@NotEmpty
	private String com;
	@NotEmpty
	private long users_id;
	@NotEmpty
	private int patient_id;
	
	
	public SuiviPatientDto() {
		super();
	}


	public SuiviPatientDto(int id, @NotEmpty String com, @NotEmpty long user, @NotEmpty int patient) {
		
		this.id = id;
		this.com = com;
		this.users_id = user;
		this.patient_id = patient;
	}


	public int getId() {
		return this.id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCom() {
		return com;
	}


	public void setCom(String com) {
		this.com = com;
	}


	public long getUserId() {
		return users_id;
	}
	
	


	public void setUserId(long users_id) {
		this.users_id = users_id;
	}


	public int getPatientId() {
		return patient_id;
	}


	public void setPatientId(int patient) {
		this.patient_id = patient;
	}


	@Override
	public String toString() {
		return "SuiviPatientDto [id=" + id + ", com=" + com + ", user=" + users_id + ", patient=" + patient_id + "]";
	}
	
	
}
