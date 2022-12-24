package com.pruebaportfolio.pruebaportrp.Service;

import com.pruebaportfolio.pruebaportrp.Entity.DescripcionPers;
import com.pruebaportfolio.pruebaportrp.Repository.RDescripcionPers;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SDescripcionPers {
    
    @Autowired
    RDescripcionPers rDescripcionPers;
    
    public List<DescripcionPers> list(){
        return rDescripcionPers.findAll(); //arma una lista con todas las exp que encuentre
    }
    
    public Optional<DescripcionPers> getOne(int id) {
        return rDescripcionPers.findById(id);//busca una experiencia por id
        //uso "Optional" porque la experiencia puede estar, como no
    }
    
    public Optional<DescripcionPers> getByDescripcion(String descripcion) {
        return rDescripcionPers.findByDescripcion(descripcion);
    }
    
    public void save(DescripcionPers descripcionPers) {
        rDescripcionPers.save(descripcionPers);
    }
    
    public void delete(int id) {
        rDescripcionPers.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rDescripcionPers.existsById(id);
    }
    
    public boolean existsByDescripcion(String descripcion) {
        return rDescripcionPers.existsByDescripcion(descripcion);
    }
    
}
