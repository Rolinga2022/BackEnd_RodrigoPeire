
package com.pruebaportfolio.pruebaportrp.Dto;

import javax.validation.constraints.NotBlank;


public class dtoHabBlanda {
    
    @NotBlank
    private String nombreHabBlanda;
    
    @NotBlank
    private int porcentaje;
    
    //constructor

    public dtoHabBlanda() {
    }

    public dtoHabBlanda(String nombreHabBlanda, int porcentaje) {
        this.nombreHabBlanda = nombreHabBlanda;
        this.porcentaje = porcentaje;
    }
    
    //get and set

    public String getNombreHabBlanda() {
        return nombreHabBlanda;
    }

    public void setNombreHabBlanda(String nombreHabBlanda) {
        this.nombreHabBlanda = nombreHabBlanda;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    
    
}
