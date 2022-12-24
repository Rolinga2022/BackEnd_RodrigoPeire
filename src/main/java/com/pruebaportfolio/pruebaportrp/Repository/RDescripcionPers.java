package com.pruebaportfolio.pruebaportrp.Repository;

import com.pruebaportfolio.pruebaportrp.Entity.DescripcionPers;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RDescripcionPers extends JpaRepository<DescripcionPers, Integer>{
    
    public Optional<DescripcionPers> findByDescripcion(String descripcion);
    public boolean existsByDescripcion(String descripcion);
    
}
