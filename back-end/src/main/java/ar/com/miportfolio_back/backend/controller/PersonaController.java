package ar.com.miportfolio_back.backend.controller;

import ar.com.miportfolio_back.backend.model.Persona;
import ar.com.miportfolio_back.backend.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
public class PersonaController {
    @Autowired
    private IPersonaService persoServ;
    
    @PostMapping("/new/persona")
    public void agregarPersona(@RequestBody Persona pers){
        persoServ.crearPersona(pers);
    }
    
    @GetMapping("/ver/personas")
    @ResponseBody
    public List<Persona> verPersonas(){
        return persoServ.verPersona();
    }
    
    @DeleteMapping("/delete{id}")
    public void borrarPersona(@PathVariable Long id){
        persoServ.borrarPersona(id);
    }
    
    @PutMapping("/editar/persona/{id}")
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
}
