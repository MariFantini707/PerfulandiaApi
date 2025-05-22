package sucursal_api.sucursal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import sucursal_api.sucursal.sucursalApiDto.Detalle_pedidoDto;

@Service
public class ApiLogisticaClient {
    @Autowired
    private RestTemplate restTemplate;

    public Detalle_pedidoDto obtenerProductoDesdeLogistica(Integer idSucursal, Integer idProducto) {
        String url = "http://localhost:8082/api/logistica/productos/" + idProducto;
        return restTemplate.getForObject(url, Detalle_pedidoDto.class);
    }
}
