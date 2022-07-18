package com.mscomunication.buydeedback.domain.repository;

import com.mscomunication.buydeedback.domain.entity.CompraRedis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRedisRepository extends CrudRepository<CompraRedis,String> {
}
