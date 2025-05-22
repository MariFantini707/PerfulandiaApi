package administracion_api.administracion.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import administracion_api.administracion.AdministracionApiDto.TicketDto;
import administracion_api.administracion.model.Usuario;
import administracion_api.administracion.repository.UsuarioRepository;
@Service
public class UsuarioService {
  @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TicketClient ticketClient;

    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> actualizar(Integer id, Usuario datos) {
        return usuarioRepository.findById(id).map(p -> {
            p.setNombre_usuario(datos.getNombre_usuario());
            p.setRut_usuario(datos.getRut_usuario());
            p.setCorreo_usuario(datos.getCorreo_usuario());
            p.setRol(datos.getRol());
            return usuarioRepository.save(p);
        });
    }

    public boolean eliminar(Integer id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    //nuevo
    public List<TicketDto> obtenerTicketsDeSoporte(Integer idUsuario) {
    return ticketClient.obtenerTicketsPorSoporte(idUsuario);
}
}
