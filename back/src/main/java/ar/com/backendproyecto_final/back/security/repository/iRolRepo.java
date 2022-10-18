package ar.com.backendproyecto_final.back.security.repository;

import ar.com.backendproyecto_final.back.security.entity.Rol;
import ar.com.backendproyecto_final.back.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepo extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
