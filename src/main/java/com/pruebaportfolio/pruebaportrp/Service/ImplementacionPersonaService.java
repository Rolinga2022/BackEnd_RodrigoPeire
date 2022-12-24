package com.pruebaportfolio.pruebaportrp.Service;

import com.pruebaportfolio.pruebaportrp.Entity.Persona;
import com.pruebaportfolio.pruebaportrp.Interface.InterfacePersonaService;
import com.pruebaportfolio.pruebaportrp.Repository.InterfacePersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplementacionPersonaService implements InterfacePersonaService {

    
    @Autowired
    InterfacePersonaRepository interfacePersonaRepository;
    
    @Override
    public List<Persona> getPersona() {
        List<Persona> personas = interfacePersonaRepository.findAll();
        return personas;
    }

    @Override
    public void savePersona(Persona persona) {
        interfacePersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        interfacePersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = interfacePersonaRepository.findById(id).orElse(null);
        return persona;
    }
    
}
