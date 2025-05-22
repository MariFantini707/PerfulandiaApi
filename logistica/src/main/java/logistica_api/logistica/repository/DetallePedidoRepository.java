package logistica_api.logistica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import logistica_api.logistica.model.DetallePedido;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Integer>{

    // Buscar los detalles por pedido
    List<DetallePedido> findByPedidoId(Integer idPedido);
}
