package com.an2m.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.an2m.dto.ChambresDto;
import com.an2m.model.Chambres;
@Repository
public interface ChambreRepository extends JpaRepository<Chambres, Integer>{

	

	
	

}
