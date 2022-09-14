package com.example.adnprueba.adnprueba.dto;

import java.io.Serializable;

public class AdnDtoInput implements Serializable {


    private String[] adn;

    public AdnDtoInput(){

    }

    public String[] getAdn() {
        return adn;
    }

    public void setAdn(String[] adn) {
        this.adn = adn;
    }
}
