package soporte_api.soporte.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import soporte_api.soporte.model.Ticket_soporte;
import soporte_api.soporte.service.Ticket_soporteService;

@RestController
@RequestMapping("/api/soporte/ticket_soporte")
public class Ticket_soporteController {
    @Autowired
    private Ticket_soporteService ticket_soporteService;

    @GetMapping
    public List<Ticket_soporte> listarticket_soportees() {
        return ticket_soporteService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket_soporte> obtenerticket_soporte(@PathVariable Integer id) {
        return ticket_soporteService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Ticket_soporte crearticket_soporte(@RequestBody Ticket_soporte ticket_soporte) {
        return ticket_soporteService.guardar(ticket_soporte);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarticket_soporte(@PathVariable Integer id, @RequestBody Ticket_soporte datos) {
        try {
            Optional<Ticket_soporte> ticket_soporteActualizado = ticket_soporteService.actualizar(id, datos);
        
            if (ticket_soporteActualizado.isPresent()) {
                return ResponseEntity.ok(ticket_soporteActualizado.get());
            } else {
                return ResponseEntity.status(404).body("ticket_soporte no encontrado con ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar el ticket_soporte: " + e.getMessage());
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarticket_soporte(@PathVariable Integer id) {
        if (ticket_soporteService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
