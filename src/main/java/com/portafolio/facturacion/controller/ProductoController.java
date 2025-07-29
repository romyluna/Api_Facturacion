package com.portafolio.facturacion.controller;


import com.portafolio.facturacion.dto.ProductoDTO;
import com.portafolio.facturacion.service.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/V1/productos")
@Slf4j //para logs
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> save(@RequestBody ProductoDTO productoDTO){
        //probando para el log slf4j
        log.info("informacion productoDTO {}",productoDTO); //mostraria por consola esta info.
        return new ResponseEntity<>(productoService.save(productoDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> findAll(){
        List<ProductoDTO> productoDTOS = productoService.findAll();
        if(productoDTOS.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productoDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> findById(@PathVariable Integer id){
       return productoService.findById(id)
               .map(productoDTO ->{
                   return ResponseEntity.ok(productoDTO);}
        ).orElse(ResponseEntity.notFound().build());
       //se puede poner: .orElseGet(() -> ResponseEntity.notFound().build()) si lo que voy a usar es muy pesado/ costoso

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteByID(@PathVariable Integer id){
            if(productoService.deleteByID(id))
                return ResponseEntity.noContent().build(); //204 para delete
            return ResponseEntity.notFound().build();

    }

    @PutMapping
    public ResponseEntity<ProductoDTO>update(@RequestBody ProductoDTO productoDTO){
            return productoService.update(productoDTO)
                    .map(productoActualizado ->
                        ResponseEntity.ok(productoActualizado)
                    ).orElse(ResponseEntity.notFound().build());
    }

}
