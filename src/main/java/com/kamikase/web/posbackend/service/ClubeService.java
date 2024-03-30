package com.kamikase.web.posbackend.service;

import com.kamikase.web.posbackend.model.Clube;
import com.kamikase.web.posbackend.repository.ClubeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Slf4j
@Service
public class ClubeService {

    @Autowired
    private ClubeRepository repository;


    public Clube cadastrar(Clube clube) { return repository.save(clube); }
    public List<Clube> listarClubes() {
        return repository.findAll();
    }

    public List<Clube> listarAsc() {
        return repository.findAllByOrderByNomeAsc();
    }

    public Clube listarPorId(Integer id) {
        return repository.findById(Long.valueOf(id)).orElseThrow(RuntimeException::new);
    }

    public Clube listarPorNome(String nome) {
        return repository.findByNome(nome);
    }

    public Clube alterar(Clube clube) {
        if (Objects.isNull(clube.getId())) {
            throw new RuntimeException();
        }
        return repository.save(clube);
    }

    public void deletar(Integer id) { repository.deleteById(Long.valueOf(id)); }



}
