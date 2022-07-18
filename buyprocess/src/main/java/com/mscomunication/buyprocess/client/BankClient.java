package com.mscomunication.buyprocess.client;

import com.mscomunication.buyprocess.client.dto.PagamentoDTO;
import com.mscomunication.buyprocess.client.dto.RetornoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "bank",
        url = "${bank.url}",
        path = "/bank")
public interface BankClient {

    @PostMapping(path = "/pagamento")
    ResponseEntity<RetornoDTO> pagamento(@RequestBody PagamentoDTO pagamentoDTO);
}