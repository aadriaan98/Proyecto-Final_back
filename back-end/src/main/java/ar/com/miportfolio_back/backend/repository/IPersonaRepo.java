package ar.com.miportfolio_back.backend.repository;

import ar.com.miportfolio_back.backend.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepo extends JpaRepository<Persona, Long> {  
}
