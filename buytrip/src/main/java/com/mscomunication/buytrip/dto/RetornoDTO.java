package com.mscomunication.buytrip.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class RetornoDTO {

    private String mensagem;
    private String chavePesquisa;
}
