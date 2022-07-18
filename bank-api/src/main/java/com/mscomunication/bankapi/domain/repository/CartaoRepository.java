package com.mscomunication.bankapi.domain.repository;


import com.mscomunication.bankapi.domain.entity.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao,Long> {


    @Query("select count(obj.id) from Cartao obj where obj.codigoSeguranca = ?1 and obj.nroCartao = ?2")
    Integer findCartaoValido(Integer codigoSeguranca, Integer nroCartao);

    @Query("select count(obj.id) from Cartao obj where obj.codigoSeguranca = ?1 and obj.nroCartao = ?2 and obj.valorCredito >= ?3")
    Integer isSaldoSuficiente(Integer codigoSeguranca, Integer nroCartao, BigDecimal valorCompra);

    @Query("from Cartao obj where obj.codigoSeguranca = ?1 and obj.nroCartao = ?2")
    Cartao findCartao(Integer codigoSeguranca, Integer nroCartao);

    @Modifying
    @Query("update Cartao set valorCredito = (valorCredito - ?3) where codigoSeguranca = ?1 and nroCartao = ?2 ")
    void atualizarSaldo(Integer codigoSeguranca, Integer nroCartao, BigDecimal valorCompra);

}
