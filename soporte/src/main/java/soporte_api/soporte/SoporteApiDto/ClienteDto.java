package soporte_api.soporte.SoporteApiDto;

import lombok.Data;

@Data
public class ClienteDto {
    private Integer id;
    private String nombre_cliente;
    private String correo_cliente;
    private String direccion_cliente;
}
