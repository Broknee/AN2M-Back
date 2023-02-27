package com.an2m.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.an2m.repository.ChambreRepository;
import com.an2m.repository.LitsRepo;
import com.an2m.repository.PatientRepo;
import com.an2m.repository.Suivi_patientRepo;
@Component
public class An2mService {

	@Autowired
	private ChambreRepository chambresRepo;
	@Autowired
	private LitsRepo litsRepo;
	@Autowired
	private PatientRepo patientRepo;
	@Autowired
	private Suivi_patientRepo suivi_patientRepo;

	public ChambreRepository getChambresRepo() {
		return chambresRepo;
	}
	public void setChambresRepo(ChambreRepository chambresRepo) {
		this.chambresRepo = chambresRepo;
	}
	public LitsRepo getLitsRepo() {
		return litsRepo;
	}
	public void setLitsRepo(LitsRepo litsRepo) {
		this.litsRepo = litsRepo;
	}
	public PatientRepo getPatientRepo() {
		return patientRepo;
	}
	public void setPatientRepo(PatientRepo patientRepo) {
		this.patientRepo = patientRepo;
	}
	public Suivi_patientRepo getSuivi_patientRepo() {
		return suivi_patientRepo;
	}
	public void setSuivi_patientRepo(Suivi_patientRepo suivi_patientRepo) {
		this.suivi_patientRepo = suivi_patientRepo;
	}
	

}
