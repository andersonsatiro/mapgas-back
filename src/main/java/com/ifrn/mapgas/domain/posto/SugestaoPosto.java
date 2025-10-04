package com.ifrn.mapgas.domain.posto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ifrn.mapgas.domain.location.Endereco;
import com.ifrn.mapgas.domain.people.Usuario;
import com.ifrn.mapgas.domain.enums.StatusSugestaoPosto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "sugestao_posto")
public class SugestaoPosto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 200)
    private String observacao;

    @NotNull
    @OneToOne
    @JsonManagedReference
    @JoinColumn(name = "endereco_id", nullable = false, referencedColumnName = "id")
    private Endereco endereco;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusSugestaoPosto status;

    @NotNull
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "usuario_id", nullable = false, referencedColumnName = "id")
    private Usuario usuario;

    @Column(name = "data_aprovacao")
    private Date dataAprovacao;

    @Column(name = "data_rejeicao")
    private Date dataRejeicao;

    private Date dataCadastro;

    @PrePersist
    protected void onCreate() { dataCadastro = new Date(); }
}
