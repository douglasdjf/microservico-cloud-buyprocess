package com.mscomunication.bankapi.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoDTO {

    private Integer nroCartao;

    private Integer codigoSeguranca;

    private BigDecimal valorCompra;
}
