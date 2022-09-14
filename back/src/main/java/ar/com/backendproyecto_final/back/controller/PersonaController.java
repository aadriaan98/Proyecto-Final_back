package ar.com.backendproyecto_final.back.controller;


import ar.com.backendproyecto_final.back.model.Persona;
import ar.com.backendproyecto_final.back.service.IPersonaService;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    
    @Autowired IPersonaService persoServ;
    
    @GetMapping("/personas/traer")
    @ResponseBody
    public List<Persona> traerPersona(){
        return persoServ.getPersona();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String agregarPersona(@RequestBody Persona pers){
        persoServ.savePersona(pers);
        return "La persona fue creada";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar{id}")
    public String borrarPersona(@PathVariable Long id){
        persoServ.deletePersona(id);
        return "La persona fue eliminada";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    public Persona editarPersona(@PathVariable Long id,
                                 @RequestParam("nombre") String nuevoNombre,
                                 @RequestParam("apellido") String nuevoApellido,
                                 @RequestParam("edad") String nuevaEdad){
      
      Persona pers = persoServ.findPersona(id);
      
      pers.setNombre(nuevoNombre);
      pers.setApellido(nuevoApellido);
      pers.setEdad(nuevaEdad);
      
      persoServ.savePersona(pers);
      
      return pers;
    }
    
    @GetMapping("personas/traer/perfil")
    public Persona traerPerfil(){
        return persoServ.findPersona((long)1);
    }
}
