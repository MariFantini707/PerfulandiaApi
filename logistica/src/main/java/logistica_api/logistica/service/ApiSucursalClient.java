package logistica_api.logistica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import logistica_api.logistica.logisticaApiDto.ProductoDto;

@Service
public class ApiSucursalClient {

    @Autowired
    private RestTemplate restTemplate;

    public ProductoDto obtenerProductoDesdeSucursal(Integer idSucursal, Integer idProducto) {
        String url = "http://localhost:8085/api/sucursal/productos/" + idProducto;
        return restTemplate.getForObject(url, ProductoDto.class);
    }
}
