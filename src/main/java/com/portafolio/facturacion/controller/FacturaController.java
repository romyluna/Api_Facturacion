package com.portafolio.facturacion.controller;

import com.portafolio.facturacion.dto.RequestFacturaDTO;
import com.portafolio.facturacion.dto.ResponseFacturaDTO;
import com.portafolio.facturacion.service.FacturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/facturas")
public class FacturaController {

    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    //SAVE
    @PostMapping
    public ResponseFacturaDTO save(@RequestBody RequestFacturaDTO requestFacturaDTO){
        return facturaService.save(requestFacturaDTO);
    }

    //FIND ALL
    @GetMapping
    public ResponseEntity<List<ResponseFacturaDTO>> findAll(){
        List<ResponseFacturaDTO> responseFacturaDTOS = facturaService.findAll();
        if(responseFacturaDTOS.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(responseFacturaDTOS);
    }

    //FIND BY ID

    @GetMapping("/{id}")
    public ResponseEntity<ResponseFacturaDTO> findById(@PathVariable Integer id){
        Optional<ResponseFacturaDTO> factura = facturaService.findById(id);
        return factura.map(
                ResponseEntity::ok
        ).orElseGet(
                ()-> ResponseEntity.notFound().build()
        );
    }

    //DELETE

    @DeleteMapping("/{id}")
    public void deleteById (@PathVariable Integer id){
        facturaService.deleteById(id);

    }

}
