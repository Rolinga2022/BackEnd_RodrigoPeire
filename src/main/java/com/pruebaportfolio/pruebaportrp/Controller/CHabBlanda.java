package com.pruebaportfolio.pruebaportrp.Controller;

import com.pruebaportfolio.pruebaportrp.Dto.dtoHabBlanda;
import com.pruebaportfolio.pruebaportrp.Entity.HabBlanda;
import com.pruebaportfolio.pruebaportrp.Security.Controller.Mensaje;
import com.pruebaportfolio.pruebaportrp.Service.SHabBlanda;
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
@RequestMapping("/habblanda")
@CrossOrigin(origins = "https://frontend-rodrigop.web.app")
public class CHabBlanda {
    
    @Autowired
    SHabBlanda sHabBlanda;
    
    @GetMapping("/lista")
    public ResponseEntity<List<HabBlanda>> list() {
        List<HabBlanda> list = sHabBlanda.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHabBlanda dtoblanda) {
        
        if(StringUtils.isBlank(dtoblanda.getNombreHabBlanda()))
            return new ResponseEntity(new Mensaje("La habilidad blanda es obligatoria"), HttpStatus.BAD_REQUEST);
        
        if(sHabBlanda.existsByNombreHabBlanda(dtoblanda.getNombreHabBlanda()))
            return new ResponseEntity(new Mensaje("Esa habilidad blanda ya existe"), HttpStatus.BAD_REQUEST);
        
        HabBlanda habBlanda = new HabBlanda (dtoblanda.getNombreHabBlanda()
                ,dtoblanda.getPorcentaje());
        sHabBlanda.save(habBlanda);
        
        return new ResponseEntity(new Mensaje("Habilidad blanda agregada"), HttpStatus.OK); 
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<HabBlanda> getById(@PathVariable("id") int id){
        if(!sHabBlanda.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        HabBlanda habBlanda = sHabBlanda.getOne(id).get();
        return new ResponseEntity(habBlanda, HttpStatus.OK);
    }
    
    //para actualizar habilidad blanda
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHabBlanda dtoblanda){
        
        //valido si existe el id
        if(!sHabBlanda.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        //comparo nombre de la habilidad blanda
        if(sHabBlanda.existsByNombreHabBlanda(dtoblanda.getNombreHabBlanda()) && sHabBlanda.getByNombreHabBlanda(dtoblanda.getNombreHabBlanda()).get().getId()!=id)
            return new ResponseEntity(new Mensaje("Esa habilidad blanda ya existe"), HttpStatus.BAD_REQUEST);
        
        //no puede estar vacio
        if(StringUtils.isBlank(dtoblanda.getNombreHabBlanda()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        HabBlanda habBlanda = sHabBlanda.getOne(id).get();
        habBlanda.setNombreHabBlanda(dtoblanda.getNombreHabBlanda());
        habBlanda.setPorcentaje(dtoblanda.getPorcentaje());
        
        sHabBlanda.save(habBlanda);
        return new ResponseEntity(new Mensaje("Habilidad blanda actualizada"), HttpStatus.OK);
        
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //valido si existe el id
        if(!sHabBlanda.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sHabBlanda.delete(id);
        
        return new ResponseEntity(new Mensaje("Habilidad blanda eliminada eliminada"), HttpStatus.OK);
    }
    
    
   
    
}
