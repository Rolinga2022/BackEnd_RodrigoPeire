
package com.pruebaportfolio.pruebaportrp.Controller;

import com.pruebaportfolio.pruebaportrp.Entity.Persona;
import com.pruebaportfolio.pruebaportrp.Service.ImplementacionPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://frontend-rodrigopeire.web.app/")
public class PersonaController {
    
    @Autowired 
    ImplementacionPersonaService implementacionPersonaService;
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersona() {
        return implementacionPersonaService.getPersona();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona) {
        implementacionPersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        implementacionPersonaService.deletePersona(id);
        return "La perosna fue eliminada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    public Persona editarPersona(@PathVariable Long id,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("apellido") String nuevoApellido,
                                @RequestParam("img") String nuevoImg) {
        
        Persona persona = implementacionPersonaService.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        
        implementacionPersonaService.savePersona(persona);
        return persona;                         
    }
    
    @GetMapping("/personas/perfil")
    public Persona findPersona(){
        return implementacionPersonaService.findPersona((long)1);
    }
    
    
    
}
