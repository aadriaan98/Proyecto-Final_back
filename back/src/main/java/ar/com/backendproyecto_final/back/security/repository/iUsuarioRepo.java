package ar.com.backendproyecto_final.back.security.repository;

import ar.com.backendproyecto_final.back.security.entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iUsuarioRepo extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    
    boolean existsByNombreUsuario(String nombreUsuario); 
    boolean existsByEmail(String email);
}
