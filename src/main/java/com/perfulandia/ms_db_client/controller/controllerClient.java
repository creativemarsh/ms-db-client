package com.perfulandia.ms_db_client.controller;

import com.perfulandia.ms_db_client.model.dto.DTOClient;
import com.perfulandia.ms_db_client.service.serviceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.perfulandia.ms_db_client.model.dto.DTOPedido;

/**
 * Controlador que actúa también como implementación de la Clase ServiceClient.
 */
@RestController
@RequestMapping("/clients")
@CrossOrigin("*")
public class controllerClient {

    @Autowired
    private serviceClient serviceClient;

    // ✅ Nuevo endpoint para crear pedidos
    @PostMapping("/orders")
    public DTOPedido createOrder(@RequestBody DTOPedido pedido) {
        return serviceClient.createOrder(pedido);
    }

    @GetMapping("")
    public List<DTOClient> getAllClients() {
        return serviceClient.getAllClients();
    }

    @GetMapping("/{id}")
    public DTOClient getClientById(@PathVariable(name = "id") Long id) {
        return serviceClient.getClientById(id);
    }

    @PostMapping("")
    public DTOClient saveClient(@RequestBody DTOClient dtoClient) {
        return serviceClient.saveClient(dtoClient);
    }

    // ✅ Nuevo endpoint para Login
    @PostMapping("/login")
    public DTOClient login(@RequestBody DTOClient loginRequest) {
        return serviceClient.login(loginRequest.getEmail(), loginRequest.getPassword());
    }

    @PutMapping("/{id}")
    public DTOClient updateClient(@PathVariable(name = "id") Long id, @RequestBody DTOClient dtoClient) {
        return serviceClient.updateClient(id, dtoClient);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable(name = "id") Long id) {
        serviceClient.deleteClient(id);
    }
}

