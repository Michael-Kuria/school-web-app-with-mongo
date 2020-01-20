package com.michael.schoolWebAppwithmongo.repository;

import com.michael.schoolWebAppwithmongo.documents.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student,String> {

}
