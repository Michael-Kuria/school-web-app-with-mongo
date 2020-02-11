package com.michael.schoolWebAppwithmongo.documents;

import lombok.Data;

@Data
public class Error {

    private String message;

    public Error(String message){

        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
