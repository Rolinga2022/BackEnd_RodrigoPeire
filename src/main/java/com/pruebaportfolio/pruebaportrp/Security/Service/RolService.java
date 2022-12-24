
package com.pruebaportfolio.pruebaportrp.Security.Service;

import com.pruebaportfolio.pruebaportrp.Security.Entity.Rol;
import com.pruebaportfolio.pruebaportrp.Security.Enums.RolNombre;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pruebaportfolio.pruebaportrp.Security.Repository.iRolRepository;

@Service
@Transactional
public class RolService {
    
    @Autowired
    iRolRepository interfaceRolRepository;
    
    public Optional<Rol>getByRolNombre(RolNombre rolNombre){
        return interfaceRolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol) {
        interfaceRolRepository.save(rol);
    }
    
}
