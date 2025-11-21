package com.perfulandia.ms_db_client.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfulandia.ms_db_client.model.dto.DTOClient;
import com.perfulandia.ms_db_client.model.entities.entityClient;
import com.perfulandia.ms_db_client.model.repositories.repositoryClient;

@Service
public class serviceClient {

    @Autowired
    private repositoryClient repository;

    // Obtener todos los clientes
    public List<DTOClient> getAllClients() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    // Obtener cliente por ID
    public DTOClient getClientById(Long id) {
        entityClient client = repository.findById(id).orElse(null);
        return client != null ? toDto(client) : null;
    }

    // Guardar nuevo cliente
    public DTOClient saveClient(DTOClient dtoClient) {
        entityClient entity = toEntity(dtoClient);
        return toDto(repository.save(entity));
    }

    // ✅ Actualizar cliente existente
    public DTOClient updateClient(Long id, DTOClient dtoClient) {
        entityClient existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setNameClient(dtoClient.getNameClient());
            existing.setEmailClient(dtoClient.getEmailClient());
            existing.setPhoneClient(dtoClient.getPhoneClient());
            return toDto(repository.save(existing));
        }
        return null; // O puedes lanzar una excepción si prefieres
    }

    // ✅ Eliminar cliente por ID
    public void deleteClient(Long id) {
        repository.deleteById(id);
    }

    // Conversión de Entity a DTO
    private DTOClient toDto(entityClient entity) {
        return new DTOClient(
            entity.getId(),
            entity.getNameClient(),
            entity.getEmailClient(),
            entity.getPhoneClient()
        );
    }

    // Conversión de DTO a Entity
    private entityClient toEntity(DTOClient dto) {
        entityClient entity = new entityClient();
        entity.setId(dto.getId());
        entity.setNameClient(dto.getNameClient());
        entity.setEmailClient(dto.getEmailClient());
        entity.setPhoneClient(dto.getPhoneClient());
        return entity;
    }
}
