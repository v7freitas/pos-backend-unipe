package com.kamikase.web.posbackend.model;

import com.kamikase.web.posbackend.validator.ClubeValidation;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tableClube")
public class Clube implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ClubeValidation
    @NotEmpty(message = "Nome é obrigatório")
    private String nome;

    @NotEmpty(message = "Estado é pbrigatório")
    private String estado;

    @NotEmpty(message = "Email é obrigatório")
    @Email
    private String email;

    @NotEmpty(message = "Cnpj é obrigatório")
    @CNPJ
    private String cnpj;

    @NotEmpty
    @NotNull
    private String dataCriacao;

}
