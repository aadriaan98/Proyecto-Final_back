package ar.com.backendproyecto_final.back.security.service;

import ar.com.backendproyecto_final.back.security.entity.Rol;
import ar.com.backendproyecto_final.back.security.enums.RolNombre;
import ar.com.backendproyecto_final.back.security.repository.iRolRepo;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    
    @Autowired iRolRepo iRolRepo;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return iRolRepo.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        iRolRepo.save(rol);
    }
}
