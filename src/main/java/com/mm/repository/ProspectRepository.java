package com.mm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mm.model.Prospect;

@Repository
public interface ProspectRepository extends JpaRepository<Prospect, Integer> {

   
}

