package com.example.accessingdatamysql.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.accessingdatamysql.domain.EpargneComptes;

public interface EpargneCompteRepository extends CrudRepository<EpargneComptes, Integer>{

}
