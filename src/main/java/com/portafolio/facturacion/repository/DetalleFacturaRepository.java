package com.portafolio.facturacion.repository;

import com.portafolio.facturacion.model.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleFacturaRepository extends JpaRepository <DetalleFactura ,Integer> {

}
