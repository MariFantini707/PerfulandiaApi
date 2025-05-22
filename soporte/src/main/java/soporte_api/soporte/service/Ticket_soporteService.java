package soporte_api.soporte.service;
import org.springframework.stereotype.Service;

import soporte_api.soporte.SoporteApiDto.UsuarioDto;
import soporte_api.soporte.model.Ticket_soporte;
import soporte_api.soporte.repository.Ticket_soporteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class Ticket_soporteService {
    @Autowired
    private Ticket_soporteRepository ticket_soporteRepository;

    @Autowired
    private UsuarioClient usuarioClient;

    public List<Ticket_soporte> obtenerTodos() {
        return ticket_soporteRepository.findAll();
    }

    public Optional<Ticket_soporte> obtenerPorId(Integer id) {
        return ticket_soporteRepository.findById(id);
    }

    public Ticket_soporte guardar(Ticket_soporte ticket_soporte) {
        return ticket_soporteRepository.save(ticket_soporte);
    }

    public Optional<Ticket_soporte> actualizar(Integer id, Ticket_soporte datos) {
        return ticket_soporteRepository.findById(id).map(p -> {
            p.setDescripcion(datos.getDescripcion());
            p.setEstadoTicket(datos.getEstadoTicket());
            p.setFecha_termino(datos.getFecha_termino());
            p.setFecha_inicio(datos.getFecha_inicio());
            p.setRespuesta_ticket(datos.getRespuesta_ticket());
            return ticket_soporteRepository.save(p);
        });
    }

    public boolean eliminar(Integer id) {
        if (ticket_soporteRepository.existsById(id)) {
            ticket_soporteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    //Ejemplo: obtener datos del usuario que responde
    public String obtenerNombreUsuarioSoporte(Integer idUsuario) {
        UsuarioDto usuario = usuarioClient.obtenerUsuarioPorId(idUsuario);
        return usuario.getNombre_usuario();
    }

    //obtiene todos los tickets asginados a un soporte usando al id
    public List<Ticket_soporte> obtenerTicketsPorUsuarioSoporte(Integer idUsuario) {
        return ticket_soporteRepository.findByIdUsuarioSoporte(idUsuario);
    }


}
