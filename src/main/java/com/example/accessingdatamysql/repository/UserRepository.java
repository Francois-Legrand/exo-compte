package com.example.accessingdatamysql.repository;


import org.springframework.data.repository.CrudRepository;

import com.example.accessingdatamysql.domain.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	
}
