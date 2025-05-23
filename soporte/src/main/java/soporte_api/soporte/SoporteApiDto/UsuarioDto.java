package soporte_api.soporte.SoporteApiDto;

import lombok.Data;

@Data
public class UsuarioDto {
    private Integer id_usuario;
    private String nombre_usuario;
    private String rut_usuario;
    private String correo_usuario;
    private RolDto rol;
    //private Sucursal sucursal

    @Data
    public static class RolDto {
        private Integer id;
        private String nombre;
    }
}
