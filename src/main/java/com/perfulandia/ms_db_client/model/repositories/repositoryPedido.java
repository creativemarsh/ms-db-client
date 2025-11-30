package com.perfulandia.ms_db_client.model.repositories;

import com.perfulandia.ms_db_client.model.entities.entityPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface repositoryPedido extends JpaRepository<entityPedido, Long> {
    List<entityPedido> findByUsuarioId(Long usuarioId);
}
