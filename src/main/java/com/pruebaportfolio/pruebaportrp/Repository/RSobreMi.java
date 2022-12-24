package com.pruebaportfolio.pruebaportrp.Repository;

import com.pruebaportfolio.pruebaportrp.Entity.SobreMi;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RSobreMi extends JpaRepository<SobreMi, Integer>{
    
    public Optional<SobreMi> findByDato(String dato);
    public boolean existsByDato(String dato);
       
}
