
package com.pruebaportfolio.pruebaportrp.Repository;

import com.pruebaportfolio.pruebaportrp.Entity.HabBlanda;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHabBlanda extends JpaRepository<HabBlanda, Integer>{
    
    public Optional<HabBlanda> findByNombreHabBlanda(String nombreHabBlanda);
    public boolean existsByNombreHabBlanda(String nombreHabBlanda);
    
}
