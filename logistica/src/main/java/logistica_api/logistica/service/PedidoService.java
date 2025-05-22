package logistica_api.logistica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import logistica_api.logistica.model.Pedido;
import logistica_api.logistica.repository.PedidoRepository;

import java.util.List;
import java.util.Optional;

@Service

public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> obtenerTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> obtenerPorId(Integer id) {
        return pedidoRepository.findById(id);
    }

    public Pedido guardar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Optional<Pedido> actualizar(Integer id, Pedido datos) {
        return pedidoRepository.findById(id).map(p -> {
            p.setFecha_Pedido(datos.getFecha_Pedido());
            p.setEstado_pedido(datos.getEstado_pedido());
            p.setTotal_pedido(datos.getTotal_pedido());
            p.setProveedor(datos.getProveedor()); // tambien se podría actualizar el proveedor si asi lo queremos
            return pedidoRepository.save(p);
        });
    }

    public boolean eliminar(Integer id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
