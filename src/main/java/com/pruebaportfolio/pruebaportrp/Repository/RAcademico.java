
package com.pruebaportfolio.pruebaportrp.Repository;

import com.pruebaportfolio.pruebaportrp.Entity.Academico;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RAcademico extends JpaRepository<Academico, Integer> {
    
    public Optional<Academico> findByNombreInstituto(String nombreInstituto);
    public boolean existsByNombreInstituto(String nombreInstituto);
    
}
