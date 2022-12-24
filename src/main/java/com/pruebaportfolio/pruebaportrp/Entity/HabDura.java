
package com.pruebaportfolio.pruebaportrp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HabDura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombreHabDura;
    
    private int porcentaje;
    
    //constructor

    public HabDura() {
    }

    public HabDura(String nombreHabDura, int porcentaje) {
        this.nombreHabDura = nombreHabDura;
        this.porcentaje = porcentaje;
    }
    
    //get and set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
