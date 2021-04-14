package com.example.accessingdatamysql.resources;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.accessingdatamysql.IDao.IDao;
import com.example.accessingdatamysql.domain.Comptes;
import com.example.accessingdatamysql.domain.CurrentComptes;
import com.example.accessingdatamysql.domain.Versement;
import com.example.accessingdatamysql.repository.VersementRepository;

@RestController
@RequestMapping(path = "/versement")
public class VersementController {

	@Autowired
	VersementRepository versementRepository;
	@Autowired
	private IDao<CurrentComptes> currentCompteRepository;
	
	// Get all comptes
		@GetMapping(path = "/all")
		public @ResponseBody Iterable<Versement> getAllVersement() {
			return versementRepository.findAll();
		}
		
		@PostMapping(path = "/add/{id}")
		
		public Versement addNewVersement(@PathVariable Integer id, @RequestParam Double montant, @RequestParam Date dateOperation) {
			
			CurrentComptes comptes = new CurrentComptes();
			comptes = currentCompteRepository.findById(id);
			
			Versement versement = new Versement(montant, dateOperation, comptes);
			versement.setDateOperation(dateOperation); 
			versement.setMontant(montant);
			versement.setComptes(comptes);
			return versementRepository.save(versement);
		}
		
		
}
