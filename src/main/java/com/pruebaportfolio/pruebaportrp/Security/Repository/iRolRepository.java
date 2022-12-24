
package com.pruebaportfolio.pruebaportrp.Security.Repository;

import com.pruebaportfolio.pruebaportrp.Security.Entity.Rol;
import com.pruebaportfolio.pruebaportrp.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
