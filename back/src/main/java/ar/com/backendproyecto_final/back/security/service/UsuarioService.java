package ar.com.backendproyecto_final.back.security.service;

import ar.com.backendproyecto_final.back.security.entity.Usuario;
import ar.com.backendproyecto_final.back.security.repository.iUsuarioRepo;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    iUsuarioRepo iUsuarioRepo;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
        return iUsuarioRepo.findByNombreUsuario(nombreUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario) {
        return iUsuarioRepo.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByEmail(String email) {
        return iUsuarioRepo.existsByEmail(email);
    }

    public void save(Usuario usuario) {
        iUsuarioRepo.save(usuario);
    }
}
