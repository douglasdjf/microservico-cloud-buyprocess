package com.mscomunication.buyprocess.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@Setter
public class CompraChaveDTO {

    private String chave;
    private CompraDTO compra;
}
