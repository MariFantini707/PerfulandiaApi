package logistica_api.logistica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import logistica_api.logistica.model.Envio;
import logistica_api.logistica.repository.EnvioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EnvioService {

    @Autowired
    private EnvioRepository envioRepository;

    public List<Envio> obtenerTodos() {
        return envioRepository.findAll();
    }

    public Optional<Envio> obtenerPorId(Integer id) {
        return envioRepository.findById(id);
    }

    public Envio guardar(Envio envio) {
        return envioRepository.save(envio);
    }

    public Optional<Envio> actualizar(Integer id, Envio datos) {
        return envioRepository.findById(id).map(e -> {
            e.setFecha_envio(datos.getFecha_envio());
            e.setEstado_envio(datos.getEstado_envio());
            e.setOrigen(datos.getOrigen());
            return envioRepository.save(e);
        });
    }

    public boolean eliminar(Integer id) {
        if (envioRepository.existsById(id)) {
            envioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
