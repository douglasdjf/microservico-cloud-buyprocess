package com.mscomunication.buyprocess.client.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
public class RetornoDTO {

    private String mensagem;
    private boolean isValid;
}
