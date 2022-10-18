package ar.com.backendproyecto_final.back.service;

import ar.com.backendproyecto_final.back.model.Persona;
import java.util.List;

public interface IPersonaService {
    //traer

    public List<Persona> getPersona();

    //guardar
    public void savePersona(Persona pers);

    //eliminar 
    public void deletePersona(Long id);

    //buscar
    public Persona findPersona(Long id);

}
