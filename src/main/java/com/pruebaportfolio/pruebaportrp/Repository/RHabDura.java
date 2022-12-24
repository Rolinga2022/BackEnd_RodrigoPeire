package com.pruebaportfolio.pruebaportrp.Repository;

import com.pruebaportfolio.pruebaportrp.Entity.HabDura;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHabDura extends JpaRepository<HabDura, Integer> {
    
    public Optional<HabDura> findByNombreHabDura(String nombreHabDura);
    public boolean existsByNombreHabDura(String nombreHabDura);
    
}
