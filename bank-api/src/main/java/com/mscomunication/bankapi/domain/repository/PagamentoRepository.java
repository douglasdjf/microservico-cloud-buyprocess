package com.mscomunication.bankapi.domain.repository;

import com.mscomunication.bankapi.domain.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento,Long> {
}
