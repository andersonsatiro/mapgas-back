package com.ifrn.mapgas.posto.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "preco_posto")
public class PrecoPosto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Min(0)
    @Column(name = "valor", nullable = false)
    private Double valor;

    @NotNull
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "posto_id", nullable = false, referencedColumnName = "id")
    private Posto posto;

    @NotNull
    @Column(name = "data_cadastro", nullable = false)
    private Date dataCadastro;

    @PrePersist
    protected void onCreate() { dataCadastro = new Date(); }
}
