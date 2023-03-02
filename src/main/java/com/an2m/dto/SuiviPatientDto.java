package com.an2m.dto;

import jakarta.validation.constraints.NotEmpty;

public class SuiviPatientDto {
	
	

	private int id;

	@NotEmpty
	private String com;
	@NotEmpty
	private long usersid;
	@NotEmpty
	private int patientid;
	
	
	public SuiviPatientDto() {
		
	}


	public SuiviPatientDto(int id,  String com, long usersid,  int patientid) {
		
		this.id = id;
		this.com = com;
		this.usersid = usersid;
		this.patientid = patientid;
	}


	public int getId() {
		return id;
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


	public long getUsersid() {
		return usersid;
	}


	public void setUsersid(long usersid) {
		this.usersid = usersid;
	}


	public int getPatientid() {
		return patientid;
	}


	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}

	
	
}
