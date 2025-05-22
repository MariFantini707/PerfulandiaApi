package sucursal_api.sucursal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sucursal_api.sucursal.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
