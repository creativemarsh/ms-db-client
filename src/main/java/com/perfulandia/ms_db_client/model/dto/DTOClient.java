package com.perfulandia.ms_db_client.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor 
public class DTOClient {

    @Schema(description = "Identificador único del cliente", accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty("id_client")
    private Long id;

    @Schema(description = "Nombre del cliente", example = "Juan Pérez")
    @NotBlank(message = "El nombre del cliente no puede estar en blanco")
    @JsonProperty("Nombre_Cliente")
    private String nameClient;

    @Schema(description = "Dirección del cliente", example = "Calle Falsa 123")
    @NotBlank(message = "La dirección del cliente no puede estar en blanco")
    @JsonProperty("Correo_Cliente")
    private String emailClient;

    @Schema(description = "Dirección del cliente", example = "123456789")
    @NotBlank(message = "El teléfono del cliente no puede estar en blanco")
    @JsonProperty("Telefono_Cliente")
    private String phoneClient;
}
