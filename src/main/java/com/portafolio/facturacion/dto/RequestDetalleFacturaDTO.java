package com.portafolio.facturacion.dto;

import lombok.Data;

@Data
public class RequestDetalleFacturaDTO {

    private Integer idProducto;
    private Integer cantidad;
}
