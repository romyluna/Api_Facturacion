package com.portafolio.facturacion.dto;

import lombok.Data;

import java.util.Set;

@Data
public class RequestFacturaDTO {

    private Integer id;
    private String numeroFactura;
    private Set<RequestDetalleFacturaDTO> detalleFacturas;
}
