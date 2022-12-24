package com.pruebaportfolio.pruebaportrp.Service;

import com.pruebaportfolio.pruebaportrp.Entity.SobreMi;
import com.pruebaportfolio.pruebaportrp.Repository.RSobreMi;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SSobreMi {
    
    @Autowired
    RSobreMi rSobreMi;
    
    public List<SobreMi> list(){
        return rSobreMi.findAll(); //arma una lista con todas los datos mios que encuentre
    }
    
    public Optional<SobreMi> getOne(int id) {
        return rSobreMi.findById(id);//busca un dato por id
        //uso "Optional" porque la dato puede estar, como no
    }
    
    public Optional<SobreMi> getByDato(String dato) {
        return rSobreMi.findByDato(dato);
    }
    
    public void save(SobreMi sobreMi) {
        rSobreMi.save(sobreMi);
    }
    
    public void delete(int id) {
        rSobreMi.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rSobreMi.existsById(id);
    }
    
    public boolean existsByDato(String dato) {
        return rSobreMi.existsByDato(dato);
    }
    
}
