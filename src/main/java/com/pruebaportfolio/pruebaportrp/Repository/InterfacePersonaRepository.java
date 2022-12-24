
package com.pruebaportfolio.pruebaportrp.Repository;

import com.pruebaportfolio.pruebaportrp.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfacePersonaRepository extends JpaRepository<Persona, Long> {
    
}
