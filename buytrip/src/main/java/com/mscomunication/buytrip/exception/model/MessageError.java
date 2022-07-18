package com.mscomunication.buytrip.exception.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class MessageError implements Serializable {

    private String messagem;
    private Integer status;
    private LocalDateTime timestamp;
    private List<ErrorException> erros;

}
