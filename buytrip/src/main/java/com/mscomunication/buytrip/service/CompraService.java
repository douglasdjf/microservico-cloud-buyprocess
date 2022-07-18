package com.mscomunication.buytrip.service;
import com.mscomunication.buytrip.dto.CompraChaveDTO;
import com.mscomunication.buytrip.dto.CompraDTO;
import com.mscomunication.buytrip.dto.RetornoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CompraService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${fila.saida}")
    private String nomeFila;

    public RetornoDTO registraCompra(CompraDTO compraDTO){
       log.info("Registrando compra...");
        CompraChaveDTO compraChave = CompraChaveDTO.builder()
                .compra(compraDTO)
                .chave(UUID.randomUUID().toString())
                .build();

        rabbitTemplate.convertAndSend(nomeFila,compraChave);

        return RetornoDTO.builder()
                .mensagem("Compra registrada com sucesso. Aguarda a confirmação do pagamento.")
                .chavePesquisa(compraChave.getChave())
                .build();
    }

}
