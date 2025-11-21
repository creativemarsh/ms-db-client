package com.perfulandia.ms_db_client.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Entidad que representa a un cliente en la base de datos.
 */
@Entity
@Table(name = "client")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class entityClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nombre del cliente (no nulo)
    @Column(name = "name_client", nullable = false)
    private String nameClient;

    // Correo electrónico (no nulo)
    @Column(name = "email_client", nullable = false)
    private String emailClient;

    // Teléfono del cliente (no nulo)
    @Column(name = "phone_client", nullable = false)
    private String phoneClient;

}
