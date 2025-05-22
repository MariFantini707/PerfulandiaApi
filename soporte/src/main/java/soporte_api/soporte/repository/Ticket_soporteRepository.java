package soporte_api.soporte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import soporte_api.soporte.model.Ticket_soporte;

public interface Ticket_soporteRepository extends JpaRepository<Ticket_soporte, Integer> {
    // Buscar por estado
    List<Ticket_soporte> findByEstadoTicket(String estado_ticket);
    
    // Buscar por id
    List<Ticket_soporte> findByIdTicket(String id_ticket);
}
