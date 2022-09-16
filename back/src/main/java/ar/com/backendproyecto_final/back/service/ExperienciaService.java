package ar.com.backendproyecto_final.back.service;

import ar.com.backendproyecto_final.back.model.Experiencia;
import ar.com.backendproyecto_final.back.repository.ExperienciaRepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService {
    
    @Autowired ExperienciaRepo expRepo;
    
    public List<Experiencia> list(){
        return expRepo.findAll();
    }
    
    public Optional<Experiencia> getOne(int id){
        return expRepo.findById(id);
    }
    
    public Optional<Experiencia> getByNombreExp(String nombreExp){
        return expRepo.findByNombreExp(nombreExp);
    }
    
    public void save(Experiencia exp){
        expRepo.save(exp);
    }
    
    public void delete(int id){
        expRepo.deleteById(id);
    }
    
    public boolean existById(int id){
        return expRepo.existsById(id);
    }
    
    public boolean existByNombreExp(String nombreExp){
        return expRepo.existsByNombreExp(nombreExp);
    }
}
