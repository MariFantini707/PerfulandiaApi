package administracion_api.administracion.service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import administracion_api.administracion.model.Rol;
import administracion_api.administracion.repository.RolRepository;
@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;

    public List<Rol> obtenerTodos() {
        return rolRepository.findAll();
    }

    public Optional<Rol> obtenerPorId(Integer id) {
        return rolRepository.findById(id);
    }

    public Rol guardar(Rol rol) {
        return rolRepository.save(rol);
    }

    public Optional<Rol> actualizar(Integer id, Rol datos) {
        return rolRepository.findById(id).map(p -> {
            p.setNombre_rol(datos.getNombre_rol());
            p.setTelefono_rol(datos.getTelefono_rol());
            p.setCorreo_rol(datos.getCorreo_rol());
            p.setDireccion_rol(datos.getDireccion_rol());
            return rolRepository.save(p);
        });
    }

    public boolean eliminar(Integer id) {
        if (rolRepository.existsById(id)) {
            rolRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
