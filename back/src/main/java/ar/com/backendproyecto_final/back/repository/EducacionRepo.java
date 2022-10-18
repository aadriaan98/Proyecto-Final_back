package ar.com.backendproyecto_final.back.repository;

import ar.com.backendproyecto_final.back.model.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepo extends JpaRepository<Educacion, Integer> {

    public Optional<Educacion> findByNombreEd(String nombreEd);

    public boolean existsByNombreEd(String nombreEd);
}
