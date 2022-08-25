package ar.com.backendproyecto_final.back.repository;

import ar.com.backendproyecto_final.back.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepo extends JpaRepository<Persona,Long> {
    
}
