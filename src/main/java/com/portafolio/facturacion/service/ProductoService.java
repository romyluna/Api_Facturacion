package com.portafolio.facturacion.service;

import com.portafolio.facturacion.dto.ProductoDTO;
import com.portafolio.facturacion.model.Producto;
import com.portafolio.facturacion.repository.ProductoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    //inyeccion de dependencia
    private final ProductoRepository productoRepository;
    private final ModelMapper modelMapper;

    public ProductoService(ProductoRepository productoRepository, ModelMapper modelMapper) {
        this.productoRepository = productoRepository;
        this.modelMapper = modelMapper;
    }

    //SAVE

    public ProductoDTO save (ProductoDTO productoDTO){

        //lo que me envian como productoDTO lo guardo como un objeto producto
        Producto producto = modelMapper.map(productoDTO, Producto.class);
        //envio a guardar el objeto producto y ademas lo reconvierto para que me devuelva el producto como un dto
        return modelMapper.map(productoRepository.save(producto),ProductoDTO.class);

        /* otra forma de armarlo si quiero:
        Producto producto = modelMapper.map(productoDTO, Producto.class);
        productoRepository.save(producto);
        return modelMapper.map(producto,ProductoDTO.class);
        */

    }

    //FIND ALL

    public List<ProductoDTO> findAll () {

        return productoRepository.findAll()
                .stream()
                .map(producto -> modelMapper.map(producto, ProductoDTO.class))
                .toList();  //   .collect(Collectors.toList()); en versiones mas viejas de java usaban este.

    }

    //FIND BY ID

    public Optional<ProductoDTO> findById (Integer id){
        return productoRepository.findById(id)
        .map(producto -> modelMapper.map(producto, ProductoDTO.class));
    }

    //DELETE BY ID

    public boolean deleteByID (Integer id){
        return productoRepository.findById(id)
                .map(producto -> { //con este producto que encontraste ahora borralo de la BD.
                            productoRepository.delete(producto);
                            return true;
                        }
                ).orElse(false);

    }

    //UPDATE

    public Optional<ProductoDTO> update (ProductoDTO productoDTO){

        //GuardO como un producto lo que se manda como DTO, y si encuentra el ID de ese producto,
        // lo guarda, y después lo devuelve como DTO
        Producto producto = modelMapper.map(productoDTO,Producto.class);

        return productoRepository.findById(producto.getId())
                .map(productoBD -> modelMapper.map(productoRepository.save(producto),ProductoDTO.class));

    }
}
