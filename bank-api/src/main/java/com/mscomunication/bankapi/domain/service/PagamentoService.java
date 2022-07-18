package com.mscomunication.bankapi.domain.service;

import com.mscomunication.bankapi.domain.entity.Pagamento;
import com.mscomunication.bankapi.domain.repository.PagamentoRepository;
import com.mscomunication.bankapi.dto.PagamentoDTO;
import com.mscomunication.bankapi.exception.PagamentoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private CartaoService cartaoService;

    @Transactional
    public void pagamento(PagamentoDTO pagamentoDTO){

        if( !cartaoService.isValido(pagamentoDTO.getCodigoSeguranca(), pagamentoDTO.getNroCartao()) ){
            throw new PagamentoException("Cartão inválido.");
        }

        if( !cartaoService.isSaldoSuficiente(pagamentoDTO.getCodigoSeguranca(), pagamentoDTO.getNroCartao(), pagamentoDTO.getValorCompra()) ){
            throw new PagamentoException("Cartão não possui saldo suficiente.");
        }

        Pagamento pagamento = new Pagamento();
        pagamento.setValorCompra(pagamentoDTO.getValorCompra());
        pagamento.setCartao(cartaoService.getCartao(pagamentoDTO.getCodigoSeguranca(), pagamentoDTO.getNroCartao()));

        pagamentoRepository.save(pagamento);

        cartaoService.atualizarSaldo(pagamentoDTO.getCodigoSeguranca(), pagamentoDTO.getNroCartao(), pagamentoDTO.getValorCompra());
    }
}
