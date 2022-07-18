package com.mscomunication.buyprocess.service.bank;

import com.mscomunication.buyprocess.client.BankClient;
import com.mscomunication.buyprocess.client.dto.PagamentoDTO;
import com.mscomunication.buyprocess.client.dto.RetornoDTO;
import com.mscomunication.buyprocess.dto.CompraChaveDTO;
import com.mscomunication.buyprocess.dto.PagamentoRetornoDTO;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class BankService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private BankClient bankClient;

    public PagamentoRetornoDTO pagar(CompraChaveDTO compraChaveDTO) throws IOException {

        PagamentoDTO pagamentoDTO = PagamentoDTO.builder()
                                    .nroCartao(compraChaveDTO.getCompra().getNroCartao())
                                    .codigoSeguranca(compraChaveDTO.getCompra().getCodigoSeguranca())
                                    .valorCompra(compraChaveDTO.getCompra().getValorPassagem())
                                    .build();

        try {
            RetornoDTO retornoDTO = bankClient.pagamento(pagamentoDTO).getBody();

            assert retornoDTO != null;
            return PagamentoRetornoDTO.builder()
                    .mensagem(retornoDTO.getMensagem())
                    .isValid(true)
                    .build();

        }catch (RuntimeException e){
            throw e;
        }
    }

}
