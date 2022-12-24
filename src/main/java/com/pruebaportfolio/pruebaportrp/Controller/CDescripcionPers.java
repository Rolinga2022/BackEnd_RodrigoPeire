package com.pruebaportfolio.pruebaportrp.Controller;

import com.pruebaportfolio.pruebaportrp.Dto.dtoDescripcionPers;
import com.pruebaportfolio.pruebaportrp.Entity.DescripcionPers;
import com.pruebaportfolio.pruebaportrp.Security.Controller.Mensaje;
import com.pruebaportfolio.pruebaportrp.Service.SDescripcionPers;
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
@RequestMapping("/descripcion")
@CrossOrigin(origins = "https://frontend-rodrigop.web.app/")
public class CDescripcionPers {
    
    @Autowired
    SDescripcionPers sDescripcionPers;
    
    //Para obtener la lista con las descripciones 
    @GetMapping("/lista")
    public ResponseEntity<List<DescripcionPers>> list() {
        List<DescripcionPers> list = sDescripcionPers.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    //para crear una nueva descripcion
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoDescripcionPers dtodesc) {
        
        if(StringUtils.isBlank(dtodesc.getDescripcion()))
            return new ResponseEntity(new Mensaje("La descripcion es obligatoria"), HttpStatus.BAD_REQUEST);
        
        if(sDescripcionPers.existsByDescripcion(dtodesc.getDescripcion()))
            return new ResponseEntity(new Mensaje("Esa descripcion existe"), HttpStatus.BAD_REQUEST);
        
        DescripcionPers descripcionPers = new DescripcionPers (dtodesc.getDescripcion());
        sDescripcionPers.save(descripcionPers);
        
        return new ResponseEntity(new Mensaje("Descripcion agregada"), HttpStatus.OK); 
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<DescripcionPers> getById(@PathVariable("id") int id){
        if(!sDescripcionPers.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        DescripcionPers descripcionPers = sDescripcionPers.getOne(id).get();
        return new ResponseEntity(descripcionPers, HttpStatus.OK);
    }
    
    //para actualizar descripcion
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoDescripcionPers dtodesc){
        
        //valido si existe el id
        if(!sDescripcionPers.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        //comparo nombre de descripcion
        if(sDescripcionPers.existsByDescripcion(dtodesc.getDescripcion()) && sDescripcionPers.getByDescripcion(dtodesc.getDescripcion()).get().getId()!=id)
            return new ResponseEntity(new Mensaje("Esa descripcion ya existe"), HttpStatus.BAD_REQUEST);
        
        //no puede estar vacio
        if(StringUtils.isBlank(dtodesc.getDescripcion()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        DescripcionPers descripcionPers = sDescripcionPers.getOne(id).get();
        descripcionPers.setDescripcion(dtodesc.getDescripcion());
        
        sDescripcionPers.save(descripcionPers);
        return new ResponseEntity(new Mensaje("Descripcion actualizada"), HttpStatus.OK);
        
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //valido si existe el id
        if(!sDescripcionPers.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sDescripcionPers.delete(id);
        
        return new ResponseEntity(new Mensaje("Descripcion eliminada"), HttpStatus.OK);
    }
    
}
