package operaciones_api.operaciones.service;

import org.springframework.stereotype.Service;

import operaciones_api.operaciones.model.cliente;
import operaciones_api.operaciones.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;



@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }

    public Optional<cliente> obtenerPorId(Integer id) {
        return clienteRepository.findById(id);
    }

    public cliente guardar(cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<cliente> actualizar(Integer id, cliente datos) {
        return clienteRepository.findById(id).map(p -> {
            p.setNombre_cliente(datos.getNombre_cliente());
            p.setCorreo_cliente(datos.getCorreo_cliente());
            p.setCorreo_cliente(datos.getCorreo_cliente());
            p.setDireccion_cliente(datos.getDireccion_cliente());
            return clienteRepository.save(p);
        });
    }

    public boolean eliminar(Integer id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    
}
