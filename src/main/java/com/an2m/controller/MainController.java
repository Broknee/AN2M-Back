package com.an2m.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.an2m.dto.PatientDto;
import com.an2m.dto.UserDto;
import com.an2m.model.Chambres;
import com.an2m.model.Lits;
import com.an2m.model.Patient;
import com.an2m.model.Prospect;
import com.an2m.model.Suivi_patient;
import com.an2m.repository.ChambreRepository;
import com.an2m.repository.LitsRepo;
import com.an2m.repository.PatientRepo;
import com.an2m.repository.Suivi_patientRepo;
import com.an2m.service.An2mService;
import com.an2m.service.ProspectService;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RestController
@RequestMapping(path = "api")

public class MainController {
	@Autowired
	 private ProspectService prospectService; 
//
	@Autowired
	private An2mService an2mService;


	@Value("${welcome.message}")
	private String message;

	@Value("${error.message}")
	private String errorMessage;

	@GetMapping("/ChambresList")
	public List<Chambres> Chambres() {
		
		return an2mService.getChambresRepo().findAll();
	}

	
	@GetMapping("/addLit")
	public void addlit(Lits lit) {

		an2mService.getLitsRepo().save(lit);

	}
	
	

	@GetMapping("/ListLits")
	public List<Lits> ListLits() {

		return an2mService.getLitsRepo().findAll();
	}

	@GetMapping("/addChambre")
	public void addChambre(Chambres chambre) {

		an2mService.getChambresRepo().save(chambre);

	}

	@GetMapping("/PatientList")
	public List<Patient> PatientList() {

		return an2mService.getPatientRepo().findAll();
	}

	@GetMapping("/addPatient")
	public void addPatient(Patient patient) {

		an2mService.getPatientRepo().save(patient);
		

	}
	
	@GetMapping("/Suivi_patient/{id}")
	public Optional<Suivi_patient> Suivi_patient(@PathVariable(value = "id") int id) {

		return an2mService.getSuivi_patientRepo().findById(id);
	}

	@GetMapping("/ListPatient")
	public List<Patient> ListPatient() {

		return an2mService.getPatientRepo().findAll();

	}


	
	
//display a list of prospects
	@RequestMapping(value = { "/prospectsList" }, method = RequestMethod.GET)
	public List<Prospect> prospectsList(Model model) {

		model.addAttribute("prospectsList", prospectService.prospectsList());

		return prospectService.prospectsList();
	}

//add a Prospect
	@RequestMapping(value = { "/addProspect" })
	public String addProspect(Model model, @ModelAttribute("prospectForm") Prospect prospectForm) {

		String nom = prospectForm.getNom();
		String numerosiret = prospectForm.getNumerosiret();
		String adressepostale = prospectForm.getAdressepostale();
		String codepostal = prospectForm.getCodepostal();
		String ville = prospectForm.getVille();

		if (nom != null && nom.length() > 0 && numerosiret != null && numerosiret.length() > 0 && adressepostale != null
				&& adressepostale.length() > 0 && codepostal != null && codepostal.length() > 0 && ville != null
				&& ville.length() > 0) {
			Prospect newProspect = new Prospect(nom, numerosiret, adressepostale, codepostal, ville);
			prospectService.addProspect(newProspect);

			return "redirect:/prospectsList";
		} else {
			model.addAttribute("errorMessage", errorMessage);
		}

		return "addProspect";
	}

//	@PostMapping("/saveProspect")
//	public String saveEmployee(@ModelAttribute("prospect") Prospect prospect) {
//
//		prospectService.addProspect(prospect);
//
//		return "redirect:/prospectsList";
//	}

	@GetMapping("/updateprospect/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {

		// get employee from the service
		Prospect prospect = prospectService.findById(id);

		// set employee as a model attribute to pre-populate the form
		model.addAttribute("prospect", prospect);
		return "update";
	}

	@GetMapping("/delete_prospect/{id}")
	public String deleteEmployee(@PathVariable(value = "id") int id) {

		// call delete employee method
		this.prospectService.deleteProspect(id);
		return "redirect:/prospectsList";
	}
	
	@PostMapping("/savePatient")
	public String registrationPatient(@RequestBody PatientDto patient) {
		
		an2mService.savePatient(patient);

		return "Patient créé";
	}

}
