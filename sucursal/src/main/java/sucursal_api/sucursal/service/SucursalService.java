package sucursal_api.sucursal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sucursal_api.sucursal.model.Sucursal;
import sucursal_api.sucursal.repository.SucursalRepository;

@Service
public class SucursalService {
 @Autowired
    private SucursalRepository sucursalRepository;

    public List<Sucursal> obtenerTodos() {
        return sucursalRepository.findAll();
    }

    public Optional<Sucursal> obtenerPorId(Integer id) {
        return sucursalRepository.findById(id);
    }

    public Sucursal guardar(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    public Optional<Sucursal> actualizar(Integer id, Sucursal datos) {
        return sucursalRepository.findById(id).map(p -> {
            p.setNombre_sucursal(datos.getNombre_sucursal());
            p.setDireccion_sucursal(datos.getDireccion_sucursal());
            p.setTelefono(datos.getTelefono());
            p.setInventario(datos.getInventario());
            return sucursalRepository.save(p);
        });
    }

    public boolean eliminar(Integer id) {
        if (sucursalRepository.existsById(id)) {
            sucursalRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
