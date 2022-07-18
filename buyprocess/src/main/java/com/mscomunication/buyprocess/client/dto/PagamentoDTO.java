package com.mscomunication.buyprocess.client.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PagamentoDTO {

    private Integer nroCartao;

    private Integer codigoSeguranca;

    private BigDecimal valorCompra;
}
