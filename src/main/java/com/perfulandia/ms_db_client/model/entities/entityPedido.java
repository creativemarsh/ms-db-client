package com.perfulandia.ms_db_client.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pedidos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class entityPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @Column(name = "fecha", nullable = false)
    private String fecha;

    @Column(name = "total", nullable = false)
    private Integer total;

    @Column(name = "direccion_envio", nullable = false)
    private String direccionEnvio;

    @Column(name = "estado", nullable = false)
    private String estado;
}
