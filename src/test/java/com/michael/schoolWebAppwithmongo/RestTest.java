package com.michael.schoolWebAppwithmongo;

import com.michael.schoolWebAppwithmongo.documents.Administrator;
import com.michael.schoolWebAppwithmongo.documents.Student;
import com.michael.schoolWebAppwithmongo.repository.AdministratorRepository;
import com.michael.schoolWebAppwithmongo.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RestTest {
    @Autowired
    AdministratorRepository repository;

    @Autowired
    StudentRepository repositoryStd;

    @Test
    public void checkAdmins(){
       Administrator admin =  repository.findAdministratorByEmailIgnoreCase("martin@yahoo.com");
       System.out.println(admin);

    }

    @Test
    public void checkStudents(){
        repositoryStd.findAll().forEach(System.out::println);
    }
}
