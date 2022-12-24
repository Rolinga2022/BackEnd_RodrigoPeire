
package com.pruebaportfolio.pruebaportrp.Service;

import com.pruebaportfolio.pruebaportrp.Entity.HabDura;
import com.pruebaportfolio.pruebaportrp.Repository.RHabDura;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SHabDura {
    
    @Autowired
    RHabDura rHabDura;
    
    
    public List<HabDura> list(){
        return rHabDura.findAll(); //arma una lista con todas habilidades duras que encuentre
    }
    
    public Optional<HabDura> getOne(int id) {
        return rHabDura.findById(id);//busca una habilidad dura por id
        //uso "Optional" porque la hab blanda puede estar, como no
    }
    
    public Optional<HabDura> getByNombreHabDura(String nombreHabDura) {
        return rHabDura.findByNombreHabDura(nombreHabDura);
    }
    
    public void save(HabDura habDura) {
        rHabDura.save(habDura);
    }
    
    public void delete(int id) {
        rHabDura.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rHabDura.existsById(id);
    }
    
    public boolean existsByNombreHabDura(String nombreHabDura) {
        return rHabDura.existsByNombreHabDura(nombreHabDura);
    }
    
    
}
