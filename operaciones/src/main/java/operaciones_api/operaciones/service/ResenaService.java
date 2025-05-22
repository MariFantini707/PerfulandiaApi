package operaciones_api.operaciones.service;

import org.springframework.stereotype.Service;
import operaciones_api.operaciones.model.Resena;
import operaciones_api.operaciones.repository.ResenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class ResenaService {
    @Autowired
    private ResenaRepository resenaRepository;

    public List<Resena> obtenerTodos() {
        return resenaRepository.findAll();
    }

    public Optional<Resena> obtenerPorId(Integer id) {
        return resenaRepository.findById(id);
    }

    public Resena guardar(Resena resena) {
        return resenaRepository.save(resena);
    }

    public Optional<Resena> actualizar(Integer id, Resena datos) {
        return resenaRepository.findById(id).map(r -> {
            // Actualiza los campos necesarios aquí
            return resenaRepository.save(r);
        });
    }

    public boolean eliminar(Integer id) {
        if (resenaRepository.existsById(id)) {
            resenaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}