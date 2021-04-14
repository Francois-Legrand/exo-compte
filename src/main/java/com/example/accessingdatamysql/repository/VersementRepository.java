package com.example.accessingdatamysql.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.accessingdatamysql.domain.Versement;

public interface VersementRepository extends CrudRepository<Versement, Integer>{

}
