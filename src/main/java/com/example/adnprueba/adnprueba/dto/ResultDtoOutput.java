package com.example.adnprueba.adnprueba.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class ResultDtoOutput implements Serializable {

    private  boolean mutant;
    private  ArrayList<String> messages;

    public ResultDtoOutput(boolean mutant, ArrayList<String> messages){
        this.messages=messages;
        this.mutant=mutant;

    }

    public boolean isMutant() {
        return mutant;
    }

    public void setMutant(boolean mutant) {
        this.mutant = mutant;
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<String> messages) {
        this.messages = messages;
    }
}
