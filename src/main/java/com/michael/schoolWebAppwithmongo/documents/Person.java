package com.michael.schoolWebAppwithmongo.documents;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.annotation.Generated;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
public class Person {


    @Id
    private String id;

    private String firstName;
    private String lastName;

    private String email;

    public Person(){
        id = UUID.randomUUID().toString();
    }
}
