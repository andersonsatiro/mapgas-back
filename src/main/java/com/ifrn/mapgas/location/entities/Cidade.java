package com.ifrn.mapgas.location.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cidade")
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 150)
    private String nome;

    @NotBlank
    @Column(nullable = false, length = 10)
    private String sigla;

    @NotBlank
    @Column(name = "bandeira_imagem_url", nullable = false, unique = true)
    private String urlBandeira;

    @Column(name = "codigo_ibge", unique = true)
    private String codigoIbge;

    @NotNull
    @JsonManagedReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "estado_id", nullable = false, referencedColumnName = "id")
    private Estado estado;
}
