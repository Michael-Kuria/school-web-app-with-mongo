package com.michael.schoolWebAppwithmongo.repository;

import com.michael.schoolWebAppwithmongo.documents.Administrator;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface AdministratorRepository extends MongoRepository<Administrator,String> {
    public Administrator findAdministratorByEmailIgnoreCase(@Param("email") String email);
}
