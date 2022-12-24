package com.pruebaportfolio.pruebaportrp.Repository;

import com.pruebaportfolio.pruebaportrp.Entity.CursosYCap;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RCursosYCap extends JpaRepository<CursosYCap, Integer>{
    
    public Optional<CursosYCap> findByNombreCurso(String nombreCurso);
    public boolean existsByNombreCurso(String nombreCurso);
    
}
