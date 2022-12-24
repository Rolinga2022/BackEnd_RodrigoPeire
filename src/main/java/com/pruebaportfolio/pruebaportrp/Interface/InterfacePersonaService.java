package com.pruebaportfolio.pruebaportrp.Interface;

import com.pruebaportfolio.pruebaportrp.Entity.Persona;
import java.util.List;


public interface InterfacePersonaService {
    
    //Traer una lista de personas
    public List<Persona> getPersona();
    //esto quiere decir: traeme una lista de personas cuando ejecute el metodo getPersona()

    //Guardar un objeto del tipo persona
    public void savePersona(Persona persona);
    
    //Eliminar un objeto, buscado por id
    public void deletePersona(Long id);
    
    //Buscar una persona por id
    public Persona findPersona(Long id);
    
}
