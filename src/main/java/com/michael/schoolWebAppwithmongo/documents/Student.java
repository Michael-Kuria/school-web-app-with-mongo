package com.michael.schoolWebAppwithmongo.documents;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection ="students")
public class Student extends Person {

    private String course;

    private int yearOfStudy;
}
