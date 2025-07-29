package com.portafolio.facturacion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Table (name = "Facturas")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numeroFactura;
    private BigDecimal subTotal;
    private BigDecimal total;

    @Transient //para que no se cree una columna con este dato sino para que este dato este disponible cuando lo necesito
    private final double IVA = 0.21; // 21% IVA

    @CreationTimestamp
    private LocalDateTime fechaCreado;

    //relacion con la tabla detalleFacturas (1 a muchos):
    //set para que no se puedan repetir productos en una factura

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "factura", orphanRemoval = true)
    private Set<DetalleFactura> detalleFacturas;
}
