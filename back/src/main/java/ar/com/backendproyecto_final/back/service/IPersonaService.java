package ar.com.backendproyecto_final.back.service;

import ar.com.backendproyecto_final.back.model.Persona;
import java.util.List;


public interface IPersonaService {
     //traer
    public List<Persona> traerPersona();
    
    //guardar
    public void crearPersona(Persona pers);
    
    //eliminar 
    public void borrarPersona(Long id);
    
    //buscar
    public Persona buscarPersona(Long id);
}
