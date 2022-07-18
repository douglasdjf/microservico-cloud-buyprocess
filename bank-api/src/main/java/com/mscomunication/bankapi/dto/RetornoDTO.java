package com.mscomunication.bankapi.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RetornoDTO {

    private String mensagem;
    private boolean isValid;
}
