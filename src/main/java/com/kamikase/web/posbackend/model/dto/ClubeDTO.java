package com.kamikase.web.posbackend.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ClubeDTO {
    private String nome;
    private String email;
    private String cnpj;

    private String razao_social;
    private Object detalhes_empresa;
}
