package administracion_api.administracion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import administracion_api.administracion.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    
}
