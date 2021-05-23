package com.example.accessingdatamysql.IDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accessingdatamysql.domain.EpargneComptes;
import com.example.accessingdatamysql.repository.EpargneCompteRepository;

@Service
public class EpargneCompteIDaoImpl implements IDao<EpargneComptes>{

	@Autowired
	private EpargneCompteRepository epargneCompteRepository;
	
	@Override
	public EpargneComptes create(EpargneComptes comptes) {
		
		return epargneCompteRepository.save(comptes);
	}

	@Override
	public void update(int id) {
		epargneCompteRepository.deleteById(id);
		
	}

	@Override
	public void deleteById(int id) {
		try {
			if(epargneCompteRepository.findById(id).isPresent()) {
				EpargneComptes currentComptes = epargneCompteRepository.findById(id).get();
				epargneCompteRepository.save(currentComptes);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public EpargneComptes findById(int id) {
		
		return epargneCompteRepository.findById(id).get();
	}

	@Override
	public Iterable<EpargneComptes> findAll() {
		
		return epargneCompteRepository.findAll();
	}


}
