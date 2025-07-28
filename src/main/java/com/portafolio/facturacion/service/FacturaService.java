package com.portafolio.facturacion.service;

import com.portafolio.facturacion.dto.RequestDetalleFacturaDTO;
import com.portafolio.facturacion.dto.RequestFacturaDTO;
import com.portafolio.facturacion.dto.ResponseFacturaDTO;
import com.portafolio.facturacion.model.DetalleFactura;
import com.portafolio.facturacion.model.Factura;
import com.portafolio.facturacion.model.Producto;
import com.portafolio.facturacion.repository.DetalleFacturaRepository;
import com.portafolio.facturacion.repository.FacturaRepository;
import com.portafolio.facturacion.repository.ProductoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class FacturaService {

    //inyeccion de dependencia
    private final FacturaRepository facturaRepository;
    private final ProductoRepository productoRepository;
    private final ModelMapper modelMapper;

    public FacturaService(FacturaRepository facturaRepository, ProductoRepository productoRepository, ModelMapper modelMapper) {
        this.facturaRepository = facturaRepository;
        this.productoRepository = productoRepository;
        this.modelMapper = modelMapper;
    }

    //FIND ALL : Obtener todas las facturas

    public List<ResponseFacturaDTO> findAll(){
        return facturaRepository.findAll()
                .stream()
                .map(factura -> modelMapper.map(factura,ResponseFacturaDTO.class))
                .toList(); //.collect(collectors.tolist())
    }

    //FIND BY ID : Obtener las facturas por ID

    public Optional<ResponseFacturaDTO> findById(Integer id){
        return facturaRepository.findById(id)
                .map(factura -> modelMapper.map(factura,ResponseFacturaDTO.class));
    }

    //DELETE BY ID : Eliminar las facturas por ID

    public void deleteById (Integer id){
         facturaRepository.deleteById(id);
    }

    //SAVE

    public ResponseFacturaDTO save (RequestFacturaDTO requestFacturaDTO){
            Factura factura = new Factura();
            BigDecimal subtotalFactura = BigDecimal.ZERO; //zero para inicializarlo
            Set<DetalleFactura> detalles = new HashSet<>();

            factura.setNumeroFactura(requestFacturaDTO.getNumeroFactura());

            for(RequestDetalleFacturaDTO detalleFacturaDTO: requestFacturaDTO.getDetalleFacturas()){

                //uso el idProducto de detalle factura
                //Producto producto = productoRepository.findById(detalleFacturaDTO.getIdProducto()).get();
                Producto producto = productoRepository.findById(detalleFacturaDTO.getIdProducto()).orElseThrow(
                        ()-> new RuntimeException("producto no encontrado")
                );


                //multiplico el precio * cantidad del producto
                BigDecimal totalProducto = producto.getPrecio().multiply(BigDecimal.valueOf((detalleFacturaDTO.getCantidad())));

                //sumo el totalproducto de cada item del detalle factura
                subtotalFactura = subtotalFactura.add(totalProducto);

                DetalleFactura detalleFactura = new DetalleFactura();
                detalleFactura.setIdProducto(detalleFacturaDTO.getIdProducto());
                detalleFactura.setPrecio(producto.getPrecio());
                detalleFactura.setCantidad(detalleFacturaDTO.getCantidad());
                detalleFactura.setTotal(totalProducto);
                detalleFactura.setFactura(factura);

                detalles.add(detalleFactura);

            }

            factura.setDetalleFacturas(detalles);
            factura.setSubTotal(subtotalFactura);
            factura.setTotal(subtotalFactura.add(subtotalFactura.multiply(BigDecimal.valueOf(factura.getIVA()))));

            Factura savedFactura = facturaRepository.save(factura);
            return modelMapper.map(savedFactura,ResponseFacturaDTO.class);

    }
}
