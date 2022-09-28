package ar.com.backendproyecto_final.back.service;

import ar.com.backendproyecto_final.back.model.Skills;
import ar.com.backendproyecto_final.back.repository.SkillsRepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Transactional
@Service
public class SkillsService {
    
    @Autowired SkillsRepo skillsRepo;
    
    public List<Skills> list(){
        return skillsRepo.findAll();
    }
    
    public Optional<Skills> getOne(int id){
        return skillsRepo.findById(id);
    }
    
    public Optional<Skills> getByNombreS(String nombreS){
        return skillsRepo.findByNombreS(nombreS);
    }
    
    public void save(Skills sk){
        skillsRepo.save(sk);
    }
    
    public void delete(int id){
        skillsRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
       return skillsRepo.existsById(id);
    }
    
    public boolean existsByNombreS(String nombreS){
        return skillsRepo.existsByNombreS(nombreS);
    }
}
