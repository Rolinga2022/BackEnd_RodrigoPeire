
package com.pruebaportfolio.pruebaportrp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HabBlanda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombreHabBlanda;
    
    private int porcentaje;
    
    //constructor

    public HabBlanda() {
    }

    public HabBlanda(String nombreHabBlanda, int porcentaje) {
        this.nombreHabBlanda = nombreHabBlanda;
        this.porcentaje = porcentaje;
    }
    
   //get and set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
