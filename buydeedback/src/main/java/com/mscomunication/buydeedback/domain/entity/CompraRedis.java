package com.mscomunication.buydeedback.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.math.BigDecimal;

@RedisHash("compra")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompraRedis {

    @Id
    private String id;
    private String mensagem;

    private Integer codigoPassagem;
    private Integer nroCartao;
    private BigDecimal valorPassagem;

    private boolean pagamentoOK;

}
