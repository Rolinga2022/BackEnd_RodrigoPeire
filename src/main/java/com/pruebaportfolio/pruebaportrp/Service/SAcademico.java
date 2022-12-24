
package com.pruebaportfolio.pruebaportrp.Service;

import com.pruebaportfolio.pruebaportrp.Entity.Academico;
import com.pruebaportfolio.pruebaportrp.Repository.RAcademico;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SAcademico {
    
    @Autowired 
    RAcademico rAcademico;
    
    public List<Academico> list(){
        return rAcademico.findAll(); //arma una lista con todas formaciones que encuentre
    }
    
    public Optional<Academico> getOne(int id) {
        return rAcademico.findById(id);//busca una formacion por id
        //uso "Optional" porque la experiencia puede estar, como no
    }
    
    public Optional<Academico> getByNombreInstituto(String nombreInstituto) {
        return rAcademico.findByNombreInstituto(nombreInstituto);
    }
    
    public void save(Academico academico) {
        rAcademico.save(academico);
    }
    
    public void delete(int id) {
        rAcademico.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rAcademico.existsById(id);
    }
    
    public boolean existsByNombreInstituto(String nombreInstituto) {
        return rAcademico.existsByNombreInstituto(nombreInstituto);
    }
    
}
