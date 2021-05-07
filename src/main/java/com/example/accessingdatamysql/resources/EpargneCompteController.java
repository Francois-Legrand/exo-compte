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
import com.example.accessingdatamysql.domain.EpargneComptes;

@RequestMapping(path = "comptes/epargne")
@RestController 
public class EpargneCompteController {
	@Autowired
	private IDao<EpargneComptes> epargneCompteRepository;

	// Get all comptes
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<EpargneComptes> getAllComptes() {
		return epargneCompteRepository.findAll();
	}
	// Get compte
	@GetMapping(path = "/{id}")
	public @ResponseBody EpargneComptes one(@PathVariable Integer id) {

		return epargneCompteRepository.findById(id);
	}
	@PostMapping(path = "/add")
	public EpargneComptes addNewCompte(@ModelAttribute EpargneComptes comptes) {
		
		return epargneCompteRepository.create(comptes);
	}
	
	//Update CurrentComptes
		@PutMapping(path="/{id}/edit")
		public String currentCompteEdit(@PathVariable Integer id, @ModelAttribute EpargneComptes comptes) throws Exception {
			
			EpargneComptes epargne = epargneCompteRepository.findById(id);
			
			epargne.setSolde(comptes.getSolde());
			epargne.setUser(comptes.getUser());
			epargne.setCreated_at(comptes.getCreated_at());
			
			epargneCompteRepository.create(comptes);
			return "epargne update";
			
		}
}
