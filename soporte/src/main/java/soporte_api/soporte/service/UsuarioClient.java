package soporte_api.soporte.service;

import soporte_api.soporte.SoporteApiDto.UsuarioDto;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "administracion-api", url = "http://localhost:8081") 
public interface UsuarioClient {
    @GetMapping("/api/administracion/usuarios")
    List<UsuarioDto> obtenerUsuarios();

    @GetMapping("/api/administracion/usuarios/{id}")
    UsuarioDto obtenerUsuarioPorId(@PathVariable("id") Integer id);
}
