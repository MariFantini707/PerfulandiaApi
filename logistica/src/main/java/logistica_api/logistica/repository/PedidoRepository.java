package logistica_api.logistica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import logistica_api.logistica.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

    List<Pedido> findByEstadoPedido(String estado_pedido); // puedo buscar pedidos por estado

    List<Pedido> findByProveedorIdProveedor(Integer idProveedor); // por proveeedor

    List<Pedido> findByFechaPedido(java.util.Date fechaPedido); //por fecha exacta
}
