package com.portafolio.facturacion.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name ="detalles")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DetalleFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer idProducto;
    private Integer cantidad;
    private BigDecimal precio;
    private BigDecimal total;

    @CreationTimestamp
    private LocalDateTime fechaCreado;

    //para relacionar detalleFactura con factura
    @ManyToOne
    @JsonIgnore
    private Factura factura;
}
