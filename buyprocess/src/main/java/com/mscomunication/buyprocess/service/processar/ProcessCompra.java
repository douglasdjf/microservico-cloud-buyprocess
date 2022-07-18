package com.mscomunication.buyprocess.service.processar;

import com.mscomunication.buyprocess.dto.CompraChaveDTO;
import com.mscomunication.buyprocess.dto.CompraFinalizadaDTO;
import com.mscomunication.buyprocess.dto.PagamentoRetornoDTO;
import com.mscomunication.buyprocess.service.bank.BankService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class ProcessCompra {

    @Autowired
    private BankService bankService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ModelMapper modelMapper;

    @Value("${fila.entrada}")
    private String nomeFilaRepublicar;

    @Value("${fila.finalizado}")
    private String nomeFilaFinalizado;

    @HystrixCommand(fallbackMethod = "republicOnMessage")
    @RabbitListener(queues="${fila.entrada}")
    public void onMessage(@Payload CompraChaveDTO compraChaveDTO) throws  IOException {
        log.info("Lendo fila de entrada...");
        PagamentoRetornoDTO pg = bankService.pagar(compraChaveDTO);

        CompraFinalizadaDTO compraFinalizadaDTO = CompraFinalizadaDTO.builder()
                .compraChaveDTO(compraChaveDTO)
                .isPagamentoOk(pg.isValid())
                .mensagem(pg.getMensagem())
                .build();

        rabbitTemplate.convertAndSend(nomeFilaFinalizado, compraFinalizadaDTO);
    }

    public void republicOnMessage(@Payload CompraChaveDTO compraChaveDTO) throws  IOException  {
        log.info("Republicando mensagem...");
        rabbitTemplate.convertAndSend(nomeFilaRepublicar, compraChaveDTO);
    }

}
