package logistica_api.logistica.logisticaApiDto;

public class ProductoDto {

    private Integer id_producto;
    private String nombre_producto;
    private String descripcion_producto;
    private Integer precio_producto;  // Si queremos incluir los otros id's
    private Integer id_inventario;
    private Integer id_categoria;

    // Getters y setters

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public Integer getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(Integer precio_producto) {
        this.precio_producto = precio_producto;
    }

    public Integer getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(Integer id_inventario) {
        this.id_inventario = id_inventario;
    }

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }
}
