package com.example.accessingdatamysql.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.accessingdatamysql.IDao.IDao;
import com.example.accessingdatamysql.domain.CurrentComptes;

@RestController
@RequestMapping(path = "/comptes/current")
public class CurrentCompteController {
	@Autowired
	private IDao<CurrentComptes> currentCompteRepository;

	// Get all comptes
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<CurrentComptes> getAllComptes() {
		return currentCompteRepository.findAll();
	}
	// Get compte
	@GetMapping(path = "/{id}")
	public @ResponseBody CurrentComptes one(@PathVariable Integer id) {

		return currentCompteRepository.findById(id);
	}
	@PostMapping(path = "/add")
	public CurrentComptes addNewCompte(@ModelAttribute CurrentComptes comptes) {
		
		return currentCompteRepository.create(comptes);
	}
	
	//Update CurrentComptes
		@PutMapping(path="/{id}/edit")
		public String currentCompteEdit(@PathVariable Integer id, @ModelAttribute CurrentComptes currentComptes) throws Exception {
			
			CurrentComptes current = currentCompteRepository.findById(id);
			
			current.setDecouvert(currentComptes.getDecouvert());
			current.setSolde(currentComptes.getSolde());
			current.setUser(currentComptes.getUser());
			current.setCreated_at(currentComptes.getCreated_at());
			currentCompteRepository.create(currentComptes); 
			return "change currentCompte";
			
		}
}
