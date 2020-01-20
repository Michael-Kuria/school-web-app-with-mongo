package com.michael.schoolWebAppwithmongo.documents;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;

@Data
public class Person {

    @Id
    private String id;

    private String firstName;
    private String lastName;

    private String email;
}
