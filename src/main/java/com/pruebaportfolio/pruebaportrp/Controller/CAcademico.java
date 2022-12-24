
package com.pruebaportfolio.pruebaportrp.Controller;

import com.pruebaportfolio.pruebaportrp.Dto.dtoAcademico;
import com.pruebaportfolio.pruebaportrp.Entity.Academico;
import com.pruebaportfolio.pruebaportrp.Security.Controller.Mensaje;
import com.pruebaportfolio.pruebaportrp.Service.SAcademico;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/academico")
@CrossOrigin(origins = "http://localhost:4200")
public class CAcademico {
    
    @Autowired
    SAcademico  sAcademico;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Academico>> list() {
        List<Academico> list = sAcademico.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoAcademico dtoacad) {
        
        if(StringUtils.isBlank(dtoacad.getNombreInstituto()))
            return new ResponseEntity(new Mensaje("El instituto es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(sAcademico.existsByNombreInstituto(dtoacad.getNombreInstituto()))
            return new ResponseEntity(new Mensaje("Ese instituto ya existe"), HttpStatus.BAD_REQUEST);
        
        Academico academico = new Academico (dtoacad.getNombreInstituto()
                ,dtoacad.getTitulo(),dtoacad.getDuracion());
        sAcademico.save(academico);
        
        return new ResponseEntity(new Mensaje("Formación académica agregada"), HttpStatus.OK); 
    } 
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Academico> getById(@PathVariable("id") int id){
        if(!sAcademico.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Academico academico = sAcademico.getOne(id).get();
        return new ResponseEntity(academico, HttpStatus.OK);
    }
    
    //para actualizar formacion academica
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoAcademico dtoacad){
        
        //valido si existe el id
        if(!sAcademico.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        //comparo nombre de la formacion academica
        if(sAcademico.existsByNombreInstituto(dtoacad.getNombreInstituto()) && sAcademico.getByNombreInstituto(dtoacad.getNombreInstituto()).get().getId()!=id)
            return new ResponseEntity(new Mensaje("Esa formacion academica ya existe"), HttpStatus.BAD_REQUEST);
        
        //no puede estar vacio
        if(StringUtils.isBlank(dtoacad.getNombreInstituto()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Academico academico = sAcademico.getOne(id).get();
        academico.setNombreInstituto(dtoacad.getNombreInstituto());
        academico.setTitulo(dtoacad.getTitulo());
        academico.setDuracion(dtoacad.getDuracion());
        
        sAcademico.save(academico);
        return new ResponseEntity(new Mensaje("Formacion academica actualizada"), HttpStatus.OK);
        
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //valido si existe el id
        if(!sAcademico.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sAcademico.delete(id);
        
        return new ResponseEntity(new Mensaje("Formacion academica eliminada"), HttpStatus.OK);
    }
    
}
