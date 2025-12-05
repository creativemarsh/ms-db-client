package com.perfulandia.ms_db_client.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfulandia.ms_db_client.model.dto.DTOClient;
import com.perfulandia.ms_db_client.model.entities.entityClient;
import com.perfulandia.ms_db_client.model.repositories.repositoryClient;

import com.perfulandia.ms_db_client.model.dto.DTODetallePedido;
import com.perfulandia.ms_db_client.model.dto.DTOPedido;
import com.perfulandia.ms_db_client.model.entities.entityDetallePedido;
import com.perfulandia.ms_db_client.model.entities.entityPedido;
import com.perfulandia.ms_db_client.model.repositories.repositoryDetallePedido;
import com.perfulandia.ms_db_client.model.repositories.repositoryPedido;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class serviceClient {

    @Autowired
    private repositoryClient repository;
    
    @Autowired
    private repositoryPedido repoPedido;
    
    @Autowired
    private repositoryDetallePedido repoDetalle;



    //  Crear un nuevo pedido
    public DTOPedido createOrder(DTOPedido dtoPedido) {
        // 1. Guardar el pedido principal
        entityPedido pedido = new entityPedido();
        pedido.setUsuarioId(dtoPedido.getIdUsuario());
        pedido.setDireccionEnvio(dtoPedido.getDireccionEnvio());
        pedido.setTotal(dtoPedido.getTotal());
        pedido.setEstado("PAGADO"); // Asumimos pagado por ahora
        pedido.setFecha(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        
        entityPedido savedPedido = repoPedido.save(pedido);
        
        // 2. Guardar los detalles (productos)
        if (dtoPedido.getDetalles() != null) {
            for (DTODetallePedido detalle : dtoPedido.getDetalles()) {
                entityDetallePedido entityDetalle = new entityDetallePedido();
                entityDetalle.setPedidoId(savedPedido.getId());
                entityDetalle.setNombreProducto(detalle.getNombreProducto());
                entityDetalle.setPrecioUnitario(detalle.getPrecio());
                entityDetalle.setCantidad(detalle.getCantidad());
                repoDetalle.save(entityDetalle);
            }
        }
        
        dtoPedido.setId(savedPedido.getId());
        dtoPedido.setFecha(savedPedido.getFecha());
        dtoPedido.setEstado(savedPedido.getEstado());
        return dtoPedido;
    }

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
            existing.setNombre(dtoClient.getNombre());
            existing.setApellido(dtoClient.getApellido());
            existing.setEmail(dtoClient.getEmail());
            existing.setPassword(dtoClient.getPassword());
            existing.setTelefono(dtoClient.getTelefono());
            existing.setRegion(dtoClient.getRegion());
            existing.setComuna(dtoClient.getComuna());
            return toDto(repository.save(existing));
        }
        return null; // O puedes lanzar una excepción si prefieres
    }

    // ✅ Eliminar cliente por ID
    public void deleteClient(Long id) {
        repository.deleteById(id);
    }

    // ✅ Método para validar Login
    public DTOClient login(String email, String password) {
        entityClient user = repository.findByEmail(email).orElse(null);
        if (user != null && user.getPassword().equals(password)) {
            return toDto(user);
        }
        return null;
    }

    // Conversión de Entity a DTO
    private DTOClient toDto(entityClient entity) {
        return new DTOClient(
            entity.getId(),
            entity.getNombre(),
            entity.getApellido(),
            entity.getEmail(),
            entity.getPassword(),
            entity.getTelefono(),
            entity.getRegion(),
            entity.getComuna()
        );
    }

    // Conversión de DTO a Entity
    private entityClient toEntity(DTOClient dto) {
        entityClient entity = new entityClient();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setApellido(dto.getApellido());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setTelefono(dto.getTelefono());
        entity.setRegion(dto.getRegion());
        entity.setComuna(dto.getComuna());
        return entity;
    }
}
