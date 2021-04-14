package com.example.accessingdatamysql.IDao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accessingdatamysql.domain.User;
import com.example.accessingdatamysql.repository.UserRepository;
@Service
public class UserIDaoImpl implements IDao<User>{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User create(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public void deleteById(int id) {
		userRepository.deleteById(id);
	}

	@Override
	public void update(int id) {
		try {
			if(userRepository.findById(id).isPresent()) {
				User user = userRepository.findById(id).get();
				userRepository.save(user);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public User findById(int id) {
		
		return userRepository.findById(id).get();
	}

	@Override
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

}
