package com.pruebaportfolio.pruebaportrp.Dto;

import javax.validation.constraints.NotBlank;


public class dtoSobreMi {
    
    @NotBlank
    private String dato;
    
    //constructor

    public dtoSobreMi() {
    }

    public dtoSobreMi(String dato) {
        this.dato = dato;
    }
    
    //get and set

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }
    
    
    
}
