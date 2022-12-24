
package com.pruebaportfolio.pruebaportrp.Dto;

import javax.validation.constraints.NotBlank;


public class dtoHabDura {
    
    @NotBlank
    private String nombreHabDura;
    
    @NotBlank
    private int porcentaje;
    
    //constructor

    public dtoHabDura() {
    }

    public dtoHabDura(String nombreHabDura, int porcentaje) {
        this.nombreHabDura = nombreHabDura;
        this.porcentaje = porcentaje;
    }
    
    //get and set

    public String getNombreHabDura() {
        return nombreHabDura;
    }

    public void setNombreHabDura(String nombreHabDura) {
        this.nombreHabDura = nombreHabDura;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    
    
}
