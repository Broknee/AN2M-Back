package com.an2m.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.an2m.dto.SuiviPatientDto;
import com.an2m.model.Patient;
import com.an2m.model.Suivi_patient;
import com.an2m.model.User;
import com.an2m.repository.ChambreRepository;
import com.an2m.repository.LitsRepo;
import com.an2m.repository.PatientRepo;
import com.an2m.repository.Suivi_patientRepo;
import com.an2m.repository.UserRepository;
@Component
public class An2mService {
	@Autowired
	UserRepository userRepo;
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
	
	  public void createSuiviPatient (SuiviPatientDto suiviPatientDto) {
	    	
	    	 System.out.println("le suivi="+suiviPatientDto.getCom());
	        Suivi_patient suivi = new Suivi_patient();
	        
	        
	        //suivi.setId((int) suiviPatientDto.getId());
	        suivi.setCom(suiviPatientDto.getCom());
	        System.out.println("le suivicom:"+suivi.getCom());
	        
	        
	         
	      User  user=userRepo.findById(suiviPatientDto.getUsersid()).get();
	        suivi.setUser(user);
	        System.out.println(user.getId());
	        Optional<Patient> patient ;
	        patient= patientRepo.findById(suiviPatientDto.getPatientid());
	        suivi.setPatient(patient.get());
	        
	        
	        
	       /* suivi.setCom(suiviPatientDto.getCom());
	        System.out.println(suiviPatientDto.getCom());
	        
	        
	       Optional<User> user ;
	        //user.setId(suiviPatientDto.getUserId());
	       System.out.println("iduser="+suiviPatientDto.getUserId());
	        user=userRepo.findById(suiviPatientDto.getUserId());
	        //Patient patient = new Patient();
	        //patient.setId(suiviPatientDto.getPatientId());
	        
	        System.out.println(suiviPatientDto.getPatientId());
	        Optional<Patient> patient ;
	        patient= patientRepo.findById(suiviPatientDto.getPatientId());
	        
	        
	        suivi.setUser(user.get());
	        
	        System.out.println(user.get());
	       
	       suivi.setPatient(patient.get());
	        */ 
	        suivi_patientRepo.save(suivi);    
	        System.out.println("yo"+suivi.getCom());
	    }
}
