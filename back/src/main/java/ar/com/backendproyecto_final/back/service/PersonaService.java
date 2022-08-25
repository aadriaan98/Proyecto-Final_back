package ar.com.backendproyecto_final.back.service;

import ar.com.backendproyecto_final.back.model.Persona;
import ar.com.backendproyecto_final.back.repository.IPersonaRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{

    @Autowired IPersonaRepo iPersoRepo; 
  
    @Override
    public List<Persona> getPersona() {
        List<Persona> pers = iPersoRepo.findAll();
        return pers;
    }

    @Override
    public void savePersona(Persona pers) {
        iPersoRepo.save(pers);
    }

    @Override
    public void deletePersona(Long id) {
        iPersoRepo.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona pers = iPersoRepo.findById(id).orElse(null);
        return pers;
    }

    
}
