package com.mscomunication.buytrip.resource;

import com.mscomunication.buytrip.dto.CompraDTO;
import com.mscomunication.buytrip.dto.RetornoDTO;
import com.mscomunication.buytrip.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping
    public ResponseEntity<RetornoDTO> registrar(@Valid  @RequestBody CompraDTO compraDTO){
       return ResponseEntity.ok(compraService.registraCompra(compraDTO));
    }
}
