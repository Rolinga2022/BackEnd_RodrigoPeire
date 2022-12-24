package com.pruebaportfolio.pruebaportrp.Dto;

import javax.validation.constraints.NotBlank;


public class dtoDescripcionPers {
    
    @NotBlank
    private String descripcion;
    
    //constructor

    public dtoDescripcionPers() {
    }

    public dtoDescripcionPers(String descripcion) {
        this.descripcion = descripcion;
    }
    
    //get and set

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
