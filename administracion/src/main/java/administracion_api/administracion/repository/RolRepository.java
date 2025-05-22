package administracion_api.administracion.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import administracion_api.administracion.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer> {

}
