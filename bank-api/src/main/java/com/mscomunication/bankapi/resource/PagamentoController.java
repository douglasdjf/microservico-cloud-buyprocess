package com.mscomunication.bankapi.resource;

import com.mscomunication.bankapi.domain.service.PagamentoService;
import com.mscomunication.bankapi.dto.PagamentoDTO;
import com.mscomunication.bankapi.dto.RetornoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping(path = "/pagamento")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<RetornoDTO> pagamento(@RequestBody  PagamentoDTO pagamentoDTO) {
        pagamentoService.pagamento(pagamentoDTO);
        return ResponseEntity.ok(RetornoDTO.builder()
                                .mensagem("Pagamento registrado com sucesso")
                                .isValid(true)
                                .build());
    }
}
