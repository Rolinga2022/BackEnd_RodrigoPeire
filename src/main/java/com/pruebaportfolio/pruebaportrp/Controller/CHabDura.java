package com.pruebaportfolio.pruebaportrp.Controller;

import com.pruebaportfolio.pruebaportrp.Dto.dtoHabDura;
import com.pruebaportfolio.pruebaportrp.Entity.HabDura;
import com.pruebaportfolio.pruebaportrp.Security.Controller.Mensaje;
import com.pruebaportfolio.pruebaportrp.Service.SHabDura;
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
@RequestMapping("/habdura")
@CrossOrigin(origins = "https://frontend-rodrigop.web.app")
public class CHabDura {
    
    @Autowired
    SHabDura sHabDura;
    
    @GetMapping("/lista")
    public ResponseEntity<List<HabDura>> list() {
        List<HabDura> list = sHabDura.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHabDura dtodura) {
        
        if(StringUtils.isBlank(dtodura.getNombreHabDura()))
            return new ResponseEntity(new Mensaje("La habilidad dura es obligatoria"), HttpStatus.BAD_REQUEST);
        
        if(sHabDura.existsByNombreHabDura(dtodura.getNombreHabDura()))
            return new ResponseEntity(new Mensaje("Esa habilidad dura ya existe"), HttpStatus.BAD_REQUEST);
        
        HabDura habDura = new HabDura (dtodura.getNombreHabDura()
                ,dtodura.getPorcentaje());
        sHabDura.save(habDura);
        
        return new ResponseEntity(new Mensaje("Habilidad dura agregada"), HttpStatus.OK); 
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<HabDura> getById(@PathVariable("id") int id){
        if(!sHabDura.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        HabDura habDura = sHabDura.getOne(id).get();
        return new ResponseEntity(habDura, HttpStatus.OK);
    }
    
    //para actualizar habilidad dura
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHabDura dtodura){
        
        //valido si existe el id
        if(!sHabDura.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        //comparo nombre de la habilidad dura
        if(sHabDura.existsByNombreHabDura(dtodura.getNombreHabDura()) && sHabDura.getByNombreHabDura(dtodura.getNombreHabDura()).get().getId()!=id)
            return new ResponseEntity(new Mensaje("Esa habilidad dura ya existe"), HttpStatus.BAD_REQUEST);
        
        //no puede estar vacio
        if(StringUtils.isBlank(dtodura.getNombreHabDura()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        HabDura habDura = sHabDura.getOne(id).get();
        habDura.setNombreHabDura(dtodura.getNombreHabDura());
        habDura.setPorcentaje(dtodura.getPorcentaje());
        
        sHabDura.save(habDura);
        return new ResponseEntity(new Mensaje("Habilidad dura actualizada"), HttpStatus.OK);
        
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //valido si existe el id
        if(!sHabDura.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sHabDura.delete(id);
        
        return new ResponseEntity(new Mensaje("Habilidad dura eliminada eliminada"), HttpStatus.OK);
    }
    
}
