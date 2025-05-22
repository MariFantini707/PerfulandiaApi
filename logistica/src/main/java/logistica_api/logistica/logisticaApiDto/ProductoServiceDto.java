package logistica_api.logistica.logisticaApiDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductoServiceDto {
    @Autowired
    private RestTemplate restTemplate;

    private final String urlBaseSucursal = "localhost:8085/api/sucursal/productos"; // Cambia al URL real

    public ProductoDto obtenerProductoPorId(Integer idProducto) {
        String url = urlBaseSucursal + "/" + idProducto;
        return restTemplate.getForObject(url, ProductoDto.class);
    }
}
