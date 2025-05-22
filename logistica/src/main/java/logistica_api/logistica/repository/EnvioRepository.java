package logistica_api.logistica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import logistica_api.logistica.model.Envio;

public interface EnvioRepository extends JpaRepository<Envio, Integer>{

    // Buscar por estado
    List<Envio> findByEstadoEnvio(String estado_envio);

    //por origen
    List<Envio> findByOrigenContainingIgnoreCase(String origen);
}
