package com.example.posto_combustivel.service;

import com.example.posto_combustivel.infrastructure.entities.BombasDeCombustivel;
import com.example.posto_combustivel.infrastructure.repositories.BombaDeCombustivelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor

public class BombaDeCombustivelService {

    private final BombaDeCombustivelRepository bombaDeCombustivelRepository;

    public void criar(BombasDeCombustivel bombasDeCombustivel){
        bombaDeCombustivelRepository.save(bombasDeCombustivel);
    }

    public BombasDeCombustivel buscarBombaDeCombustivelPorId(Integer id){
        return  bombaDeCombustivelRepository.findById(id).orElseThrow(() ->
                new NullPointerException("Bomba de combustivel não encontrada pelo id " + id));
    }

    public List<BombasDeCombustivel> buscarBombaDeCombustivel(){
        return bombaDeCombustivelRepository.findAll();
    }

    @Transactional
    public void deletarBombaCombustivel(Integer id){
        bombaDeCombustivelRepository.deleteById(id);
    }

    public void alterarBombaCombustivel(Integer id, BombasDeCombustivel bombasDeCombustivel){
        BombasDeCombustivel bomba = buscarBombaDeCombustivelPorId(id);
        bombasDeCombustivel.setId(bomba.getId());
        bombaDeCombustivelRepository.save(bombasDeCombustivel);
    }
}
