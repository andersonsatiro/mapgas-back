package com.ifrn.mapgas.posto.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ifrn.mapgas.location.entities.Endereco;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "posto")
public class Posto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "razao_social", nullable = false, length = 150)
    private String razaoSocial;

    @NotBlank
    @Column(name = "nome_fantasia", nullable = false, length = 150)
    private String nomeFantasia;

    @NotNull
    @Column(nullable = false)
    private boolean status;

    @NotNull
    @Column(name = "data_cadastro", nullable = false)
    private Date dataCadastro;

    @NotNull
    @OneToOne
    @JsonManagedReference
    @JoinColumn(name = "endereco_id", nullable = false, referencedColumnName = "id", unique = true)
    private Endereco endereco;

    @PrePersist
    protected void onCreate() {
        dataCadastro = new Date();
    }
}
