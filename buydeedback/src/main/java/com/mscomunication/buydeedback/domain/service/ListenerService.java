package com.mscomunication.buydeedback.domain.service;

import com.mscomunication.buydeedback.domain.entity.CompraRedis;
import com.mscomunication.buydeedback.domain.repository.CompraRedisRepository;
import com.mscomunication.buydeedback.dto.CompraFinalizadaDTO;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ListenerService {

    @Autowired
    private CompraRedisRepository compraRedisRepository;

    @Autowired
    private ModelMapper modelMapper;

    @RabbitListener(queues="${fila.finalizado}")
    public void onMessage(@Payload CompraFinalizadaDTO compraFinalizadaDTO) throws Exception {

        try {
            CompraRedis credis = CompraRedis.builder()
                    .id(compraFinalizadaDTO.getCompraChaveDTO().getChave())
                    .mensagem(compraFinalizadaDTO.getMensagem())
                    .nroCartao(compraFinalizadaDTO.getCompraChaveDTO().getCompra().getNroCartao())
                    .valorPassagem(compraFinalizadaDTO.getCompraChaveDTO().getCompra().getValorPassagem())
                    .codigoPassagem(compraFinalizadaDTO.getCompraChaveDTO().getCompra().getCodigoPassagem())
                    .pagamentoOK(compraFinalizadaDTO.isPagamentoOk())
                    .build();

            log.info("Gravando no Redis");
            compraRedisRepository.save(credis);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
