package logistica_api.logistica.service;

import logistica_api.logistica.model.RutaEntrega;
import logistica_api.logistica.repository.RutaEntregaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RutaEntregaService {
    @Autowired
    private RutaEntregaRepository rutaEntregaRepository;

    public List<RutaEntrega> obtenerTodas() {
        return rutaEntregaRepository.findAll();
    }

    public Optional<RutaEntrega> obtenerPorId(Integer id) {
        return rutaEntregaRepository.findById(id);
    }

    public RutaEntrega guardar(RutaEntrega rutaEntrega) {
        return rutaEntregaRepository.save(rutaEntrega);
    }

    public Optional<RutaEntrega> actualizar(Integer id, RutaEntrega datos) {
        return rutaEntregaRepository.findById(id).map(r -> {
            r.setDescripcionRuta(datos.getDescripcionRuta());
            r.setDistanciaKm(datos.getDistanciaKm());
            r.setTiempoEstimado(datos.getTiempoEstimado());
            return rutaEntregaRepository.save(r);
        });
    }

    public boolean eliminar(Integer id) {
        if (rutaEntregaRepository.existsById(id)) {
            rutaEntregaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
