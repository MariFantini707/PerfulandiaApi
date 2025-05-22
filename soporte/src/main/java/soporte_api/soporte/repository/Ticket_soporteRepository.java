package soporte_api.soporte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import soporte_api.soporte.model.Ticket_soporte;

public interface Ticket_soporteRepository extends JpaRepository<Ticket_soporte, Integer> {

}
