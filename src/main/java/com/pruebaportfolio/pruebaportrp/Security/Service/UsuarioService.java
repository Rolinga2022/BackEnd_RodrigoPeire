
package com.pruebaportfolio.pruebaportrp.Security.Service;

import com.pruebaportfolio.pruebaportrp.Security.Entity.Usuario;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pruebaportfolio.pruebaportrp.Security.Repository.iUsuarioRepository;

@Service
@Transactional
public class UsuarioService {
    
    @Autowired
    iUsuarioRepository interfaceUsuarioRepository;
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return interfaceUsuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        return interfaceUsuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByEmail(String email){
        return interfaceUsuarioRepository.existsByEmail(email);
    }
    
    public void save(Usuario usuario){
        interfaceUsuarioRepository.save(usuario);
    }
    
}
