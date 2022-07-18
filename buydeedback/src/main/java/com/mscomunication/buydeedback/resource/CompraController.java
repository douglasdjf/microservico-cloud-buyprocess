package com.mscomunication.buydeedback.resource;

import com.mscomunication.buydeedback.domain.entity.CompraRedis;
import com.mscomunication.buydeedback.domain.repository.CompraRedisRepository;
import com.mscomunication.buydeedback.exceptions.NaoFinalizadoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CompraController {

    @Autowired
    private CompraRedisRepository compraRedisRepository;

    @GetMapping("/{chave}")
    public CompraRedis status(@PathVariable("chave") String chave){

        Optional<CompraRedis> compra = compraRedisRepository.findById(chave);

        if( !compra.isPresent()){
            throw new NaoFinalizadoException();
        }

        return compra.get();
    }

    @GetMapping
    public List<CompraRedis> findAll(){
        return (List<CompraRedis>) compraRedisRepository.findAll();
    }

    @GetMapping("/meunome")
    public String status(){
        return "Estou na máquina do: Douglas";
    }
}