package ar.com.miportfolio_back.backend.service;

import ar.com.miportfolio_back.backend.model.Persona;
import ar.com.miportfolio_back.backend.repository.IPersonaRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{
    
    @Autowired
    public IPersonaRepo iPersoRepo;
    
    @Override
    public List<Persona> traerPersona() {
        List<Persona> pers = iPersoRepo.findAll();
        return pers;
    }

    @Override
    public void crearPersona(Persona pers) {
        iPersoRepo.save(pers);
    }

    @Override
    public void borrarPersona(Long id) {
        iPersoRepo.deleteById(id);
    }

    @Override
    public Persona buscarPersona(Long id) {
        Persona pers = iPersoRepo.findById(id).orElse(null);
        return pers;
    }    
}
