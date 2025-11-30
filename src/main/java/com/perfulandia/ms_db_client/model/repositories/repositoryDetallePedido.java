package com.perfulandia.ms_db_client.model.repositories;

import com.perfulandia.ms_db_client.model.entities.entityDetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface repositoryDetallePedido extends JpaRepository<entityDetallePedido, Long> {
    List<entityDetallePedido> findByPedidoId(Long pedidoId);
}
