package com.mscomunication.bankapi.domain.service;

import com.mscomunication.bankapi.domain.entity.Cartao;
import com.mscomunication.bankapi.domain.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
public class CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    public boolean isValido(Integer codigoSegurancaCartao, Integer nroCartao) {
        return cartaoRepository.findCartaoValido(codigoSegurancaCartao, nroCartao) > 0;
    }

    public boolean isSaldoSuficiente(Integer codigoSegurancaCartao,
                                     Integer nroCartao, BigDecimal valorCompra) {
        return cartaoRepository.isSaldoSuficiente(codigoSegurancaCartao, nroCartao, valorCompra) > 0;
    }

    public Cartao getCartao(Integer codigoSegurancaCartao, Integer nroCartao) {
        return cartaoRepository.findCartao(codigoSegurancaCartao, nroCartao);
    }

    @Transactional
    public void atualizarSaldo(Integer codigoSegurancaCartao,
                               Integer nroCartao, BigDecimal valorCompra) {
        cartaoRepository.atualizarSaldo(codigoSegurancaCartao, nroCartao, valorCompra);
    }
}
