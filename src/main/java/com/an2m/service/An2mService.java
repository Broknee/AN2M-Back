package com.an2m.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.an2m.dto.LitsDto;
import com.an2m.dto.LitsDtoUpdate;
import com.an2m.dto.SuiviPatientDto;
import com.an2m.model.Chambres;
import com.an2m.model.Lits;
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
	  
	  public List<LitsDto> findAllUsers() {
		  List<Lits> lits = litsRepo.findAll();
	        return lits.stream().map((lit) -> convertEntityToDto(lit))
	                .collect(Collectors.toList());
	    }
	    
	    private LitsDto convertEntityToDto(Lits lit){
	    	
	        LitsDto litDto = new LitsDto();
	        
	        litDto.setId(lit.getId());
	        litDto.setStatus(lit.getStatus());
	        
	        Patient patient ;
	        patient= lit.getPatient();
	        litDto.setPatient(patient);
	        
	        Chambres chambre;
	        chambre= lit.getChambre();
	        litDto.setChambre(chambre);
	          
	        return litDto;
	    }
	    
	    
	    public void modifyDispoLits(LitsDtoUpdate litDto) {
			
			 Lits lit= litsRepo.findById(litDto.getId()).get();
			 lit.setId(litDto.getId());
			 lit.setStatus(litDto.getStatus());
			 
			 Patient patient ;
		     patient= patientRepo.findById(litDto.getPatient_id()).get();
		     lit.setPatient(patient);
		     
		     Chambres chambre;
		     chambre= chambresRepo.findById(litDto.getChambre_id()).get();
			 lit.setChambre(chambre);
			 
			
			 litsRepo.save(lit);
			
		}
	  
}
