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

    //para relacionar detalleFactura con factura : JPA asume que la clave foranea es de la tabla factura el id por eso en la tabla
    //detalles se genera la columna factura_id y se vincula con la tabla factura por medio del id (FOREING KEY)
    //si yo queria ponerle otro nombre a esa columna: @JoinColumn(referencedColumnName = "nombre_columna"
    @ManyToOne
    @JsonIgnore
    private Factura factura;
}
