package administracion_api.administracion.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import administracion_api.administracion.AdministracionApiDto.TicketDto;

import java.util.List;

@FeignClient(name = "soporte-api", url = "http://localhost:8084/api/soporte/ticket_soporte")
public interface TicketClient {
    @GetMapping("/usuario-soporte/{idUsuario}")
    List<TicketDto> obtenerTicketsPorSoporte(@PathVariable Integer idUsuario);

}
