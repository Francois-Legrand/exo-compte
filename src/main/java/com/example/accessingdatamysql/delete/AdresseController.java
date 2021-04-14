package com.example.accessingdatamysql.delete;
//package com.example.accessingdatamysql.rebu;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestAttribute;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.accessingdatamysql.Adresse;
//
//@RestController
//@RequestMapping(path="/adresse")
//public class AdresseController {
//
//	@Autowired
//	private AdresseRepository adresseRepository;
//	
//	//Get all adresse
//		@GetMapping(path="/all")
//		public @ResponseBody Iterable<Adresse> getAllAdresses() {
//			return adresseRepository.findAll();
//		}
//		
//		//Post adresse
//		@PostMapping(path="/add")
//		
//		public Adresse addNewdresse (@Validated(Adresse.class) @ModelAttribute Adresse adresse) {
//			
//	    return adresseRepository.save(adresse);
//			
//		}
//	
//}
