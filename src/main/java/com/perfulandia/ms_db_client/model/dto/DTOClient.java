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

    @Schema(description = "Identificador único del usuario", accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty("id")
    private Long id;

    @Schema(description = "Nombre del usuario", example = "Juan")
    @NotBlank(message = "El nombre es obligatorio")
    @JsonProperty("nombre")
    private String nombre;

    @Schema(description = "Apellido del usuario", example = "Pérez")
    @NotBlank(message = "El apellido es obligatorio")
    @JsonProperty("apellido")
    private String apellido;

    @Schema(description = "Correo electrónico", example = "juan.perez@duocuc.cl")
    @NotBlank(message = "El correo es obligatorio")
    @JsonProperty("email")
    private String email;

    @Schema(description = "Contraseña del usuario", example = "secret123")
    @NotBlank(message = "La contraseña es obligatoria")
    @JsonProperty("password")
    private String password;

    @Schema(description = "Teléfono del usuario", example = "+56912345678")
    @JsonProperty("telefono")
    private String telefono;

    @Schema(description = "Región del usuario", example = "Región Metropolitana")
    @NotBlank(message = "La región es obligatoria")
    @JsonProperty("region")
    private String region;

    @Schema(description = "Comuna del usuario", example = "Santiago")
    @NotBlank(message = "La comuna es obligatoria")
    @JsonProperty("comuna")
    private String comuna;
}
