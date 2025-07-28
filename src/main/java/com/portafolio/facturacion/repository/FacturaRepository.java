package com.portafolio.facturacion.repository;

import com.portafolio.facturacion.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository <Factura, Integer> {


}
