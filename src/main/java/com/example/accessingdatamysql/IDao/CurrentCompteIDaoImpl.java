package com.example.accessingdatamysql.IDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accessingdatamysql.domain.CurrentComptes;
import com.example.accessingdatamysql.repository.CurrentCompteRepository;

@Service
public class CurrentCompteIDaoImpl implements IDao<CurrentComptes>{
	
	@Autowired
	private CurrentCompteRepository currentCompteRepository;
	
	@Override
	public CurrentComptes create(CurrentComptes comptes) {
		return currentCompteRepository.save(comptes);
	}

	@Override
	public void update(int id) {
		try {
			if(currentCompteRepository.findById(id).isPresent()) {
				CurrentComptes currentComptes = currentCompteRepository.findById(id).get();
				currentCompteRepository.save(currentComptes);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteById(int id) {
		currentCompteRepository.deleteById(id);
	}

	@Override
	public CurrentComptes findById(int id) {
		return currentCompteRepository.findById(id).get();
	}

	@Override
	public Iterable<CurrentComptes> findAll() {
		return currentCompteRepository.findAll();
	}

}
