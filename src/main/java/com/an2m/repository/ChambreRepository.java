package com.an2m.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.an2m.model.Chambres;
@Repository
public interface ChambreRepository extends JpaRepository<Chambres, Integer>{
	

	
	

}
