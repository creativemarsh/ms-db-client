package com.perfulandia.ms_db_client.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTODetallePedido {
    private String nombreProducto;
    private Integer precio;
    private Integer cantidad;
}
