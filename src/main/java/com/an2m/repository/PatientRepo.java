package com.an2m.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.an2m.model.Patient;

public interface PatientRepo extends JpaRepository<Patient, Integer>{

}
