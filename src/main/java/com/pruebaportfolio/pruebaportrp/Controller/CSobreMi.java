package com.pruebaportfolio.pruebaportrp.Controller;

import com.pruebaportfolio.pruebaportrp.Dto.dtoSobreMi;
import com.pruebaportfolio.pruebaportrp.Entity.SobreMi;
import com.pruebaportfolio.pruebaportrp.Security.Controller.Mensaje;
import com.pruebaportfolio.pruebaportrp.Service.SSobreMi;
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
@RequestMapping("/sobremi")
@CrossOrigin(origins = "http://localhost:4200")
public class CSobreMi {
    
    @Autowired
    SSobreMi sSobreMi;
    
    //Para obtener la lista con los datos mios 
    @GetMapping("/lista")
    public ResponseEntity<List<SobreMi>> list() {
        List<SobreMi> list = sSobreMi.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    //para crear un nuevo dato
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSobreMi dtosobremi) {
        
        if(StringUtils.isBlank(dtosobremi.getDato()))
            return new ResponseEntity(new Mensaje("El dato es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(sSobreMi.existsByDato(dtosobremi.getDato()))
            return new ResponseEntity(new Mensaje("El dato existe"), HttpStatus.BAD_REQUEST);
        
        SobreMi sobreMi = new SobreMi (dtosobremi.getDato());
        sSobreMi.save(sobreMi);
        
        return new ResponseEntity(new Mensaje("Dato agregado"), HttpStatus.OK); 
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<SobreMi> getById(@PathVariable("id") int id){
        if(!sSobreMi.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        SobreMi sobreMi = sSobreMi.getOne(id).get();
        return new ResponseEntity(sobreMi, HttpStatus.OK);
    }
    
    //para actualizar el dato
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSobreMi dtosobremi){
        
        //valido si existe el id
        if(!sSobreMi.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        //comparo nombre del dato
        if(sSobreMi.existsByDato(dtosobremi.getDato()) && sSobreMi.getByDato(dtosobremi.getDato()).get().getId()!=id)
            return new ResponseEntity(new Mensaje("Ese dato ya existe"), HttpStatus.BAD_REQUEST);
        
        //no puede estar vacio
        if(StringUtils.isBlank(dtosobremi.getDato()))
            return new ResponseEntity(new Mensaje("El dato es obligatorio"), HttpStatus.BAD_REQUEST);
        
        SobreMi sobreMi = sSobreMi.getOne(id).get();
        sobreMi.setDato(dtosobremi.getDato());
        
        sSobreMi.save(sobreMi);
        return new ResponseEntity(new Mensaje("Dato actualizado"), HttpStatus.OK);
        
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //valido si existe el id
        if(!sSobreMi.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sSobreMi.delete(id);
        
        return new ResponseEntity(new Mensaje("Dato eliminado"), HttpStatus.OK);
    }
    
    
    
}
