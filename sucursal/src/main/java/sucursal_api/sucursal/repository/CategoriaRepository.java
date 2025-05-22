package sucursal_api.sucursal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sucursal_api.sucursal.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
    List<Categoria> findById_categoria(Integer id_categoria);
    List<Categoria> findByNombre_categoria(String nombre_categoria);
}
