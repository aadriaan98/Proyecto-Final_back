package ar.com.backendproyecto_final.back.repository;

import ar.com.backendproyecto_final.back.model.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepo extends JpaRepository<Skills, Integer> {

    Optional<Skills> findByNombreS(String nombreS);

    public boolean existsByNombreS(String nombreS);
}
