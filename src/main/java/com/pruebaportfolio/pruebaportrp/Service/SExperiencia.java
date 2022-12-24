
package com.pruebaportfolio.pruebaportrp.Service;

import com.pruebaportfolio.pruebaportrp.Entity.Experiencia;
import com.pruebaportfolio.pruebaportrp.Repository.RExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExperiencia {
    
    @Autowired //esto lo uso para inyectar
    RExperiencia rExperiencia; //en este caso, inyecto el repositorio
    
    public List<Experiencia> list(){
        return rExperiencia.findAll(); //arma una lista con todas las exp que encuentre
    }
    
    public Optional<Experiencia> getOne(int id) {
        return rExperiencia.findById(id);//busca una experiencia por id
        //uso "Optional" porque la experiencia puede estar, como no
    }
    
    public Optional<Experiencia> getByNombreE(String nombreE) {
        return rExperiencia.findByNombreE(nombreE);
    }
    
    public void save(Experiencia experiencia) {
        rExperiencia.save(experiencia);
    }
    
    public void delete(int id) {
        rExperiencia.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rExperiencia.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE) {
        return rExperiencia.existsByNombreE(nombreE);
    }
    
    
}
