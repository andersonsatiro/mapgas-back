package com.ifrn.mapgas.domain.location;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "estado")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 50, unique = true)
    private String nome;

    @NotBlank
    @Column(nullable = false, length = 2, unique = true)
    private String sigla;

    @NotBlank
    @Column(name = "bandeira_imagem_url", nullable = false, unique = true)
    private String urlBandeira;

    @Column(name = "codigo_ibge", unique = true)
    private String codigoIbge;

    @NotNull
    @OneToOne
    @JoinColumn(name = "capital_id", nullable = false, referencedColumnName = "id", unique = true)
    private Cidade capital;

    @NotNull
    @JsonManagedReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "regiao_id", nullable = false, referencedColumnName = "id")
    private Regiao regiao;
}
