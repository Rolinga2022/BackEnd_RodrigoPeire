package com.pruebaportfolio.pruebaportrp.Controller;

import com.pruebaportfolio.pruebaportrp.Dto.dtoCursosYCap;
import com.pruebaportfolio.pruebaportrp.Entity.CursosYCap;
import com.pruebaportfolio.pruebaportrp.Security.Controller.Mensaje;
import com.pruebaportfolio.pruebaportrp.Service.SCursosYCap;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
@CrossOrigin(origins = "https://frontend-rodrigop.web.app")
public class CCursosYCap {
    
    @Autowired
    SCursosYCap sCursosYCap;
    
    @GetMapping("/lista")
    public ResponseEntity<List<CursosYCap>> list() {
        List<CursosYCap> list = sCursosYCap.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
   
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoCursosYCap dtocursos) {
        
        if(StringUtils.isBlank(dtocursos.getNombreCurso()))
            return new ResponseEntity(new Mensaje("El curso es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(sCursosYCap.existsByNombreCurso(dtocursos.getNombreCurso()))
            return new ResponseEntity(new Mensaje("Ese curso/capacitacion ya existe"), HttpStatus.BAD_REQUEST);
        
        CursosYCap cursosYCap = new CursosYCap (dtocursos.getNombreCurso()
                ,dtocursos.getInstitucion(),dtocursos.getTipo(),dtocursos.getYear());
        sCursosYCap.save(cursosYCap);
        
        return new ResponseEntity(new Mensaje("Curso/Capacitacion agregada"), HttpStatus.OK); 
    } 
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<CursosYCap> getById(@PathVariable("id") int id){
        if(!sCursosYCap.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        CursosYCap cursosYCap = sCursosYCap.getOne(id).get();
        return new ResponseEntity(cursosYCap, HttpStatus.OK);
    }
    
    //para actualizar cursos y cap
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoCursosYCap dtocursos){
        
        //valido si existe el id
        if(!sCursosYCap.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        //comparo nombre del curso
        if(sCursosYCap.existsByNombreCurso(dtocursos.getNombreCurso()) && sCursosYCap.getByNombreCurso(dtocursos.getNombreCurso()).get().getId()!=id)
            return new ResponseEntity(new Mensaje("Ese curso/capacitacion ya existe"), HttpStatus.BAD_REQUEST);
        
        //no puede estar vacio
        if(StringUtils.isBlank(dtocursos.getNombreCurso()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        CursosYCap cursosYCap = sCursosYCap.getOne(id).get();
        cursosYCap.setNombreCurso(dtocursos.getNombreCurso());
        cursosYCap.setInstitucion(dtocursos.getInstitucion());
        cursosYCap.setTipo(dtocursos.getTipo());
        cursosYCap.setYear(dtocursos.getYear());
        
        sCursosYCap.save(cursosYCap);
        return new ResponseEntity(new Mensaje("Curso/capacitacion actualizado"), HttpStatus.OK);
        
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //valido si existe el id
        if(!sCursosYCap.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sCursosYCap.delete(id);
        
        return new ResponseEntity(new Mensaje("Curso/Capacitacion eliminado"), HttpStatus.OK);
    }
    
    
    
    
  
    
}
