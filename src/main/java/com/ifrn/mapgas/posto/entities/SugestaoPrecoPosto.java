package com.ifrn.mapgas.posto.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ifrn.mapgas.people.entities.Usuario;
import com.ifrn.mapgas.posto.enums.StatusSugestaoPreco;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "sugestao_preco_posto")
public class SugestaoPrecoPosto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Min(0)
    @Column(nullable = false)
    private Double valor;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusSugestaoPreco status;

    @NotNull
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "usuario_id", nullable = false, referencedColumnName = "id")
    private Usuario usuario;

    @NotNull
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "posto_id", nullable = false, referencedColumnName = "id")
    private Posto posto;

    @Column(name = "data_aprovacao")
    private Date dataAprovacao;

    @Column(name = "data_rejeicao")
    private Date dataRejeicao;

    @NotNull
    @Column(name = "data_cadastro", nullable = false)
    private Date dataCadastro;

    @PrePersist
    protected void onCreate() { dataCadastro = new Date(); }
}
