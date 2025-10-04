package com.ifrn.mapgas.domain.posto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ifrn.mapgas.domain.people.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "comparacao_posto")
public class ComparacaoPosto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "usuario_id", nullable = false, referencedColumnName = "id")
    private Usuario usuario;

    @NotNull
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "posto_1_id", nullable = false, referencedColumnName = "id")
    private Posto posto1;

    @NotNull
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "posto_2_id", nullable = false, referencedColumnName = "id")
    private Posto posto2;

    @NotNull
    @Column(name = "data_cadastro", nullable = false)
    private Date dataCadastro;

    @PrePersist
    protected void onCreate() { dataCadastro = new Date(); }
}
