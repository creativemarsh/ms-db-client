package com.perfulandia.ms_db_client.model.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTOPedido {
    private Long id;
    private Long idUsuario; // ID del usuario que compra
    private String direccionEnvio; // Calle y número ingresados en el checkout
    private Integer total;
    private String estado;
    private String fecha; // Se enviará o generará en el backend
    private List<DTODetallePedido> detalles;
}
