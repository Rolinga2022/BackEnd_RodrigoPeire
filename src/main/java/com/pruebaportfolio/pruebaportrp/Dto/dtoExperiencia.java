
package com.pruebaportfolio.pruebaportrp.Dto;

import javax.validation.constraints.NotBlank;


public class dtoExperiencia {
    
    @NotBlank
    private String nombreE;
    
    @NotBlank
    private String empresa;
    
    @NotBlank
    private String tarea;
    
    @NotBlank
    private String formato;
    
    //Constructor

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String empresa, String tarea, String formato) {
        this.nombreE = nombreE;
        this.empresa = empresa;
        this.tarea = tarea;
        this.formato = formato;
    }
    
    //get and set

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
    
    
    
    
}
