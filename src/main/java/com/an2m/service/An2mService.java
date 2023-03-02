package com.an2m.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.an2m.dto.ChambresDto;
import com.an2m.dto.LitsDto;
import com.an2m.dto.PatientDto;
import com.an2m.dto.SuiviPatientDto;
import com.an2m.dto.UserDto;
import com.an2m.dto.userDtoGet;
import com.an2m.model.Chambres;
import com.an2m.model.Lits;
import com.an2m.model.Patient;
import com.an2m.model.Role;
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
	
	
	
	public void savePatient(PatientDto patientDTO) {
		
		Patient patient= new Patient();
		
		patient.setNom(patientDTO.getNom());
		patient.setPrenom(patientDTO.getPrenom());
		patient.setSecu(patientDTO.getSecu());
		patient.setAdresse(patientDTO.getAdresse());
		patient.setTel(patientDTO.getTel());
		patient.setMail(patientDTO.getMail());
		patient.setTel_urgent(patientDTO.getTel_urgent());
		patient.setNom_urgent(patientDTO.getNom_urgent());
		patient.setPrenom_urgent(patientDTO.getPrenom_urgent());
		patient.setDate_entree(patientDTO.getDate_entree());
		patient.setDate_sortie(patientDTO.getDate_sortie());
		patient.setRaison_saijour(patientDTO.getRaison_saijour());

		patientRepo.save(patient);
		
	}
	
	
	
    public void createSuiviPatient (SuiviPatientDto suiviPatientDto) {
    	
        Suivi_patient suivi = new Suivi_patient();
        
        
        suivi.setId((int) suiviPatientDto.getId());
        suivi.setCom(suiviPatientDto.getCom());
        
        
        User user ;
        user=userRepo.findById(suiviPatientDto.getUserId()).get();
        suivi.setUser(user);
        
        Optional<Patient> patient ;
        patient= patientRepo.findById(suiviPatientDto.getPatientId());
        suivi.setPatient(patient.get());
        
        
        suivi_patientRepo.save(suivi);    
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
	

}
