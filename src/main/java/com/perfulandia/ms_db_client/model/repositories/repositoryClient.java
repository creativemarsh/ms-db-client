package com.perfulandia.ms_db_client.model.repositories;

import com.perfulandia.ms_db_client.model.entities.entityClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA que permite acceder a los datos de clientes.
 * Incluye operaciones como: findAll, findById, save, deleteById, etc.
 */
@Repository
public interface repositoryClient extends JpaRepository<entityClient, Long> {
    // Aquí podrías agregar métodos personalizados si lo necesitas, como:
    // List<entityClient> findByEmailClient(String emailClient);
}
