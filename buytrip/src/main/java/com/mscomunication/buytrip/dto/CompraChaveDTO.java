package com.mscomunication.buytrip.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class CompraChaveDTO {

    private String chave;
    private CompraDTO compra;
}
