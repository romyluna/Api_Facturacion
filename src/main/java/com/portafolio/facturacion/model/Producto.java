package com.portafolio.facturacion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="productos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String detalle;
    private BigDecimal precio;

    @CreationTimestamp //automaticamente se va a llenar con esta notacion ( la fecha)
    private LocalDate fechaCreado;
    @UpdateTimestamp  //Se utiliza para guardar automáticamente la fecha y hora de la última modificación del registro
    private LocalDate fechaActualizacion;
}
