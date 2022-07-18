package com.mscomunication.bankapi.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tb_cartao")
public class Cartao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "num_cartao")
    private Integer nroCartao;

    @Column(name = "codigo_seguranca")
    private Integer codigoSeguranca;

    @Column(name = "valor_credito")
    private BigDecimal valorCredito;
}
