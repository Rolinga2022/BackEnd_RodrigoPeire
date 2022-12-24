package com.pruebaportfolio.pruebaportrp.Dto;

import javax.validation.constraints.NotBlank;


public class dtoCursosYCap {
    
    @NotBlank
    private String nombreCurso;
    
    @NotBlank
    private String institucion;
    
    @NotBlank
    private String tipo;
    
    @NotBlank
    private String year;
    
    //constructor

    public dtoCursosYCap() {
    }

    public dtoCursosYCap(String nombreCurso, String institucion, String tipo, String year) {
        this.nombreCurso = nombreCurso;
        this.institucion = institucion;
        this.tipo = tipo;
        this.year = year;
    }
    
    //get and set

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    
    
    
}
