package com.adminn.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.adminn.demo.entities.Adminentity;
import com.adminn.demo.entities.Company;



public interface Adminrepository extends MongoRepository<Adminentity,Integer>{

}
