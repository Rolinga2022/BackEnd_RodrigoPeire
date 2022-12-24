package com.pruebaportfolio.pruebaportrp.Service;

import com.pruebaportfolio.pruebaportrp.Entity.CursosYCap;
import com.pruebaportfolio.pruebaportrp.Repository.RCursosYCap;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SCursosYCap {
    
    @Autowired
    RCursosYCap rCursosYCap;
    
    public List<CursosYCap> list(){
        return rCursosYCap.findAll(); //arma una lista con todos cursos y cap que encuentre
    }
    
    public Optional<CursosYCap> getOne(int id) {
        return rCursosYCap.findById(id);//busca un curso por id
        //uso "Optional" porque la experiencia puede estar, como no
    }
    
    public Optional<CursosYCap> getByNombreCurso(String nombreCurso) {
        return rCursosYCap.findByNombreCurso(nombreCurso);
    }
    
    public void save(CursosYCap cursosYCap) {
        rCursosYCap.save(cursosYCap);
    }
    
    public void delete(int id) {
        rCursosYCap.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rCursosYCap.existsById(id);
    }
    
    public boolean existsByNombreCurso(String nombreCurso) {
        return rCursosYCap.existsByNombreCurso(nombreCurso);
    }
    
    
    
}
