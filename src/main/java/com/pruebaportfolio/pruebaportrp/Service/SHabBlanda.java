
package com.pruebaportfolio.pruebaportrp.Service;

import com.pruebaportfolio.pruebaportrp.Entity.HabBlanda;
import com.pruebaportfolio.pruebaportrp.Repository.RHabBlanda;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SHabBlanda {
    
    @Autowired
    RHabBlanda rHabBlanda;
    
    public List<HabBlanda> list(){
        return rHabBlanda.findAll(); //arma una lista con todas habilidades blandas que encuentre
    }
    
    public Optional<HabBlanda> getOne(int id) {
        return rHabBlanda.findById(id);//busca una habilidad blanda por id
        //uso "Optional" porque la hab blanda puede estar, como no
    }
    
    public Optional<HabBlanda> getByNombreHabBlanda(String nombreHabBlanda) {
        return rHabBlanda.findByNombreHabBlanda(nombreHabBlanda);
    }
    
    public void save(HabBlanda habBlanda) {
        rHabBlanda.save(habBlanda);
    }
    
    public void delete(int id) {
        rHabBlanda.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rHabBlanda.existsById(id);
    }
    
    public boolean existsByNombreHabBlanda(String nombreHabBlanda) {
        return rHabBlanda.existsByNombreHabBlanda(nombreHabBlanda);
    }
    
}
