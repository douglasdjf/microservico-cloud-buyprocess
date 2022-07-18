package com.mscomunication.buytrip.dto;


import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class CompraDTO {

    @NotNull
    private Integer codigoPassagem;

    @NotNull
    private Integer nroCartao;

    @NotNull
    private Integer codigoSeguranca;

    @NotNull
    private BigDecimal valorPassagem;

}
