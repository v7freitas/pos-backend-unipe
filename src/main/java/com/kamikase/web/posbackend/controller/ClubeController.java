package com.kamikase.web.posbackend.controller;

import com.kamikase.web.posbackend.client.CnpjClient;
import com.kamikase.web.posbackend.model.Clube;
import com.kamikase.web.posbackend.model.dto.ClubeDTO;
import com.kamikase.web.posbackend.service.ClubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clube")
public class ClubeController {

    @Autowired
    private ClubeService service;

    @Autowired
    private CnpjClient cnpjService;

    @PostMapping
    public ResponseEntity<Clube> cadastrar(@RequestBody Clube clube) {
        clube = service.cadastrar(clube);
        return ResponseEntity.ok(clube);
    }


    @GetMapping("buscar/id/{id}")
    public ResponseEntity<ClubeDTO> buscarPorId(Integer id) {
        Clube clube = service.listarPorId(id);
        ClubeDTO clubeDTO = new ClubeDTO();
        clubeDTO.setNome(clube.getNome());
        clubeDTO.setEmail(clube.getEmail());
        clubeDTO.setCnpj(clube.getCnpj());

        return ResponseEntity.ok(clubeDTO);
    }



    @GetMapping("buscar/nome/{nome}")
    public ResponseEntity<ClubeDTO> buscarPorNome(String nome) {
        Clube clube = service.listarPorNome(nome);
        ClubeDTO clubeDTO = new ClubeDTO();
        clubeDTO.setNome(clube.getNome());
        clubeDTO.setEmail(clube.getEmail());
        clubeDTO.setCnpj(clube.getCnpj());

        return ResponseEntity.ok(clubeDTO);
    }

    @DeleteMapping("apagar/{id}")
    public ResponseEntity<Void> apagar(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("alterar/")
    public ResponseEntity<Clube> alterar(@RequestBody Clube clube) {
        Clube alteracao = service.alterar(clube);
        return ResponseEntity.ok(alteracao);
    }

    @GetMapping("buscar/todos")
    public ResponseEntity<List<ClubeDTO>> buscarTodos() {

        List<Clube> lista = service.listarClubes();
        List<ClubeDTO> clubes = new ArrayList<>();


        for (Clube clube : lista) {
            ClubeDTO clubeDTO = new ClubeDTO();
            var cnpjResponse = cnpjService.consultaCNPJ(clube.getCnpj());

            clubeDTO.setNome(clube.getNome());
            clubeDTO.setEmail(clube.getEmail());
            clubeDTO.setCnpj(clube.getCnpj());
            clubeDTO.setRazao_social(cnpjResponse.getRazao_social());
            clubeDTO.setDetalhes_empresa(cnpjResponse.getEstabelecimento());

            clubes.add(clubeDTO);
        }
        return ResponseEntity.ok(clubes);
    }

    @GetMapping("buscar/todos/asc")
    public ResponseEntity<List<ClubeDTO>> buscarTodosAsc() {

        List<Clube> lista = service.listarAsc();
        List<ClubeDTO> clubes = new ArrayList<>();


        for (Clube clube : lista) {
            ClubeDTO clubeDTO = new ClubeDTO();
            var cnpjResponse = cnpjService.consultaCNPJ(clube.getCnpj());

            clubeDTO.setNome(clube.getNome());
            clubeDTO.setEmail(clube.getEmail());
            clubeDTO.setCnpj(clube.getCnpj());
            clubeDTO.setRazao_social(cnpjResponse.getRazao_social());
            clubeDTO.setDetalhes_empresa(cnpjResponse.getEstabelecimento());

            clubes.add(clubeDTO);
        }
        return ResponseEntity.ok(clubes);
    }



}
