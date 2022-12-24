
package com.pruebaportfolio.pruebaportrp.Dto;

import javax.validation.constraints.NotBlank;


public class dtoAcademico {
    
    @NotBlank
    private String nombreInstituto;
    
    @NotBlank
    private String titulo;
    
    @NotBlank
    private String duracion;
    
    //constructor

    public dtoAcademico() {
    }

    public dtoAcademico(String nombreInstituto, String titulo, String duracion) {
        this.nombreInstituto = nombreInstituto;
        this.titulo = titulo;
        this.duracion = duracion;
    }
    
    //get and set

    public String getNombreInstituto() {
        return nombreInstituto;
    }

    public void setNombreInstituto(String nombreInstituto) {
        this.nombreInstituto = nombreInstituto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
    
    
    
}
