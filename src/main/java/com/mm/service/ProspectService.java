package com.mm.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import com.mm.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import com.mm.repository.ProspectRepository;

@Component
public class ProspectService {
	@Autowired
private ProspectRepository Prospects;
	@Autowired
	private ProspectRepository prospect;
	
	
	@Override
	public String toString() {
		return Prospects.toString();
	}
	
	public void list() {
		for (Prospect element : prospect.findAll()) {
					
					System.out.println(element);
					
				}
	}
	
	public List <Prospect> prospectsList(){

        return( List <Prospect>)prospect.findAll();
    }
	
	public void addProspect(Prospect newProspect) {
	
	prospect.save(newProspect);
	}
	
	public Prospect findById(int id) {
		  Optional < Prospect > optional = prospect.findById(id);
	        Prospect client = null;
	        if (optional.isPresent()) {
	            client = optional.get();
	        } else {
	            throw new RuntimeException(" Prospect not found for id :: " + id);
	        }
	        return client;}
	
//	public void updateCodePost(int id, String code_postal) {
//		prospect.modifyProspect(id, code_postal);
//	}
	
	public void deleteProspect(int id) {
		prospect.deleteById(id);
	}
	
	
	}


