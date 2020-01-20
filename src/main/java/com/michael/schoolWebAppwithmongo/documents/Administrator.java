package com.michael.schoolWebAppwithmongo.documents;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@Document(collection ="administrator")
public class Administrator extends Person {

    @NotNull
    private String password;

    private String role = "ADMIN";

}
