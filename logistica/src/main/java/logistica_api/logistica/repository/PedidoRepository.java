package logistica_api.logistica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import logistica_api.logistica.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
