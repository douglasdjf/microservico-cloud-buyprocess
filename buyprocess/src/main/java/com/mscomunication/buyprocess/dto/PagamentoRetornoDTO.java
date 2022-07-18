package com.mscomunication.buyprocess.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class PagamentoRetornoDTO {

    private String mensagem;
    private boolean isValid;
}
