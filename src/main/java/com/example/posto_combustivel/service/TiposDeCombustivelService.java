package com.example.posto_combustivel.service;

import com.example.posto_combustivel.infrastructure.entities.TiposDeCombustivel;
import com.example.posto_combustivel.infrastructure.repositories.TipoDeCombustivelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor

public class TiposDeCombustivelService {

    private final TipoDeCombustivelRepository tipoDeCombustivelRepository;

    public void criar(TiposDeCombustivel tiposDeCombustivel){
        tipoDeCombustivelRepository.save(tiposDeCombustivel);
    }

    private TiposDeCombustivel buscarTiposDeCombustivelPorId(Integer id){
        return  tipoDeCombustivelRepository.findById(id).orElseThrow(() ->
                new NullPointerException("Tipo de combustivel não encontrado pelo id " + id));
    }

    private List<TiposDeCombustivel> buscarTiposDeCombustivel(){
        return tipoDeCombustivelRepository.findAll();
    }

    @Transactional
    public void deletarTipoCombustivel(Integer id){
        tipoDeCombustivelRepository.deleteById(id);
    }

    private void alterarTipoDeCombustivel(Integer id, TiposDeCombustivel tiposDeCombustivel){
        TiposDeCombustivel tipoSalvo = buscarTiposDeCombustivelPorId(id);
        tiposDeCombustivel.setId(tipoSalvo.getId());
        tipoDeCombustivelRepository.save(TiposDeCombustivel.builder().build());
    }
}

