package com.michael.schoolWebAppwithmongo.documents;

import lombok.Data;

@Data
public class ErrorMessages {

    public String message;

    public ErrorMessages(String message){

        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
