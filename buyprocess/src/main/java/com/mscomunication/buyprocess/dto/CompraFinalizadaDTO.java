package com.mscomunication.buyprocess.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class CompraFinalizadaDTO {

    private CompraChaveDTO compraChaveDTO;
    private String mensagem;
    private boolean isPagamentoOk;
}
