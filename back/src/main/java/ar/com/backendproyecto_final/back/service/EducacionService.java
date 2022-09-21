package ar.com.backendproyecto_final.back.service;

import ar.com.backendproyecto_final.back.model.Educacion;
import ar.com.backendproyecto_final.back.repository.EducacionRepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService {
    @Autowired EducacionRepo eduRepo;
    
    public List<Educacion> list(){
        return eduRepo.findAll();
    }
    
    public Optional<Educacion> getOne(int id){
        return eduRepo.findById(id);
    }
    
    public Optional<Educacion> getByNombreEd(String nombreEd){
        return eduRepo.findByNombreEd(nombreEd);
    }
    
    public void save(Educacion edu){
        eduRepo.save(edu);
    }
    
    public void delete(int id){
        eduRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return eduRepo.existsById(id);
    }
    
    public boolean existsByNombreEd(String nombreEd){
        return eduRepo.existsByNombreEd(nombreEd);
    }
}
