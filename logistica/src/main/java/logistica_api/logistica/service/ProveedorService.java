package logistica_api.logistica.service;

import org.springframework.stereotype.Service;

import logistica_api.logistica.model.Proveedor;
import logistica_api.logistica.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;



@Service
public class ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> obtenerTodos() {
        return proveedorRepository.findAll();
    }

    public Optional<Proveedor> obtenerPorId(Integer id) {
        return proveedorRepository.findById(id);
    }

    public Proveedor guardar(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public Optional<Proveedor> actualizar(Integer id, Proveedor datos) {
        return proveedorRepository.findById(id).map(p -> {
            p.setNombreProveedor(datos.getNombreProveedor());
            p.setTelefonoProveedor(datos.getTelefonoProveedor());
            p.setCorreoProveedor(datos.getCorreoProveedor());
            p.setDireccionProveedor(datos.getDireccionProveedor());
            return proveedorRepository.save(p);
        });
    }

    public boolean eliminar(Integer id) {
        if (proveedorRepository.existsById(id)) {
            proveedorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    
}
