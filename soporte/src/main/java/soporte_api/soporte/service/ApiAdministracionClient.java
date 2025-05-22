package soporte_api.soporte.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import soporte_api.soporte.SoporteApiDto.UsuarioDto;

@Service
public class ApiAdministracionClient {
    @Autowired
    private RestTemplate restTemplate;

    public UsuarioDto obtenerUsuario(Integer id_usuario) {
        String url = "http://localhost:8082/administracion/usuarios/" + id_usuario;
        return restTemplate.getForObject(url, UsuarioDto.class);
    }
}
