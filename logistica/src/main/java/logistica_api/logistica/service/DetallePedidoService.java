package logistica_api.logistica.service;

//aqui los llamé


import logistica_api.logistica.model.DetallePedido;
import logistica_api.logistica.repository.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidoService {
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public List<DetallePedido> obtenerTodos() {
        return detallePedidoRepository.findAll();
    }

    public Optional<DetallePedido> obtenerPorId(Integer id) {
        return detallePedidoRepository.findById(id);
    }

    public DetallePedido guardar(DetallePedido detallePedido) {
        return detallePedidoRepository.save(detallePedido);
    }

    public Optional<DetallePedido> actualizar(Integer id, DetallePedido datos) {
        return detallePedidoRepository.findById(id).map(d -> {
            d.setCantidad(datos.getCantidad());
            d.setPedido(datos.getPedido());
            return detallePedidoRepository.save(d);
        });
    }

    public boolean eliminar(Integer id) {
        if (detallePedidoRepository.existsById(id)) {
            detallePedidoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    //esto es para probar
    
}
