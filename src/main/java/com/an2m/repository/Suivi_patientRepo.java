package com.an2m.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.an2m.model.Patient;
import com.an2m.model.Suivi_patient;

public interface Suivi_patientRepo extends JpaRepository<Suivi_patient, Integer> {

	List<Suivi_patient> findSuivi_patientByPatient(Patient patient);
		
}
