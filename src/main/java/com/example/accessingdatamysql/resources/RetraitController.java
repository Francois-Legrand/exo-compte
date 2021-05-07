package com.example.accessingdatamysql.resources;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.accessingdatamysql.domain.Comptes;
import com.example.accessingdatamysql.domain.Retrait;
import com.example.accessingdatamysql.repository.ComptesRepository;
import com.example.accessingdatamysql.repository.RetraitRepository;

@RestController
@RequestMapping(path = "/retrait")
public class RetraitController {

	@Autowired
	RetraitRepository retraitRepository;
	@Autowired
	ComptesRepository comptesRepository; 
	
	// Get all comptes
		@GetMapping(path = "/all")
		public @ResponseBody Iterable<Retrait> getAllRetrait() {
			return retraitRepository.findAll();
		}
		
		@PostMapping(path = "/add/{id}")
		
		public Retrait addNewVRetrait(@PathVariable Integer id, @RequestParam Double montant, @RequestParam Date dateOperation) throws Exception {
			
			Comptes comptes = new Comptes();
			comptes = comptesRepository.findById(id).get();
			Retrait retrait = new Retrait(montant, dateOperation, comptes);
			retrait.setDateOperation(dateOperation); 
			retrait.setMontant(montant);
			retrait.setComptes(comptes);
			return retraitRepository.save(retrait);
		}
		
		
}