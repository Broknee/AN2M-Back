package com.an2m.dto;

import com.an2m.model.Patient;
import com.an2m.model.User;
import com.an2m.repository.UserRepository;

import jakarta.validation.constraints.NotEmpty;

public class SuiviPatientDto {
	
	

	private long id;

	@NotEmpty
	private String com;
	@NotEmpty
	private long user_id;
	@NotEmpty
	private long patient_id;
	
	
	public SuiviPatientDto() {
		super();
	}


	public SuiviPatientDto(long id, @NotEmpty String com, @NotEmpty long user, @NotEmpty long patient) {
		
		this.id = id;
		this.com = com;
		this.user_id = user;
		this.patient_id = patient;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCom() {
		return com;
	}


	public void setCom(String com) {
		this.com = com;
	}


	public long getUserId() {
		return user_id;
	}
	
	


	public void setUserId(long user) {
		this.user_id = user;
	}


	public long getPatientId() {
		return patient_id;
	}


	public void setPatientId(int patient) {
		this.patient_id = patient;
	}


	@Override
	public String toString() {
		return "SuiviPatientDto [id=" + id + ", com=" + com + ", user=" + user_id + ", patient=" + patient_id + "]";
	}
	
	
}
