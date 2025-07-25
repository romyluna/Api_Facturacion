package com.portafolio.facturacion.repository;

import com.portafolio.facturacion.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository <Producto,Integer> {



}
