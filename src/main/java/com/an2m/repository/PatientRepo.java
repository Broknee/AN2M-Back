package com.an2m.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.an2m.dto.PatientDto;
import com.an2m.model.Patient;
import com.an2m.model.User;

public interface PatientRepo extends JpaRepository<Patient, Long>{


}
