package soporte_api.soporte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import soporte_api.soporte.model.Ticket_soporte;

public interface Ticket_soporteRepository extends JpaRepository<Ticket_soporte, Integer> {
    List<Ticket_soporte> findByIdUsuarioSoporte(Integer idUsuarioSoporte);
}
