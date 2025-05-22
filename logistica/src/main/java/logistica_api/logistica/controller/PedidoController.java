package logistica_api.logistica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import logistica_api.logistica.model.Envio;
import logistica_api.logistica.model.Pedido;
import logistica_api.logistica.model.Proveedor;
import logistica_api.logistica.repository.EnvioRepository;
import logistica_api.logistica.repository.PedidoRepository;
import logistica_api.logistica.repository.ProveedorRepository;
import logistica_api.logistica.service.PedidoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/logistica/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private EnvioRepository envioRepository;

    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> obtenerPedido(@PathVariable Integer id) {
        return pedidoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crearPedido(@RequestBody Pedido pedido) {
        try {
            // Obtener proveedor y envío con sus IDs
            Integer idProveedor = pedido.getProveedor() != null ? pedido.getProveedor().getIdProveedor() : null;
            Integer idEnvio = pedido.getEnvio() != null ? pedido.getEnvio().getId() : null;

            if (idProveedor == null || idEnvio == null) {
                return ResponseEntity.badRequest().body("Proveedor o Envío no especificado");
            }

            Proveedor proveedor = proveedorRepository.findById(idProveedor)
                    .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

            Envio envio = envioRepository.findById(idEnvio)
                    .orElseThrow(() -> new RuntimeException("Envío no encontrado"));

            pedido.setProveedor(proveedor);
            pedido.setEnvio(envio);

            Pedido nuevo = pedidoRepository.save(pedido);
            return ResponseEntity.ok(nuevo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear pedido: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPedido(@PathVariable Integer id, @RequestBody Pedido datos) {
        try {
            Optional<Pedido> pedidoActualizado = pedidoService.actualizar(id, datos);

            if (pedidoActualizado.isPresent()) {
                return ResponseEntity.ok(pedidoActualizado.get());
            } else {
                return ResponseEntity.status(404).body("Pedido no encontrado con la ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar el pedido: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Integer id) {
        if (pedidoService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
