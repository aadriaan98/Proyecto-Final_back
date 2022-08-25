package ar.com.backendproyecto_final.back.controller;


import ar.com.backendproyecto_final.back.model.Persona;
import ar.com.backendproyecto_final.back.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private IPersonaService persoServ;
    
    @GetMapping("/personas/traer")
    @ResponseBody
    public List<Persona> traerPersona(){
        return persoServ.traerPersona();
    }
    
    @PostMapping("/personas/crear")
    public void agregarPersona(@RequestBody Persona pers){
        persoServ.crearPersona(pers);
    }
    
    @DeleteMapping("/personas/borrar{id}")
    public void borrarPersona(@PathVariable Long id){
        persoServ.borrarPersona(id);
    }
    
    @PutMapping("/personas/editar/{id}")
    public Persona editarPersona(@PathVariable Long id,
                             @RequestParam("nombre") String nuevoNombre,
                             @RequestParam("apellido") String nuevoApellido,
                             @RequestParam("edad") String nuevaEdad){
      
      Persona pers = persoServ.buscarPersona(id);
      
      pers.setNombre(nuevoNombre);
      pers.setApellido(nuevoApellido);
      pers.setEdad(nuevaEdad);
      
      persoServ.crearPersona(pers);
      
      return pers;
    }
    
    @GetMapping("personas/traer/perfil")
    public Persona traerPerfil(){
        return persoServ.buscarPersona((long)1);
    }
}
