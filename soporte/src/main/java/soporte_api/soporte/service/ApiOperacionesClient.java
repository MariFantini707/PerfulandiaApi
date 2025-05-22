package soporte_api.soporte.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import soporte_api.soporte.SoporteApiDto.ClienteDto;

@Service
public class ApiOperacionesClient {
@Autowired
    private RestTemplate restTemplate;

    public ClienteDto obtenerCliente(Integer id_cliente) {
        String url = "http://localhost:8083/operaciones/clientes/" + id_cliente;
        return restTemplate.getForObject(url, ClienteDto.class);
    }
}
