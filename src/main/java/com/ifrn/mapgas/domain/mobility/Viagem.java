package com.ifrn.mapgas.domain.mobility;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ifrn.mapgas.domain.location.Endereco;
import com.ifrn.mapgas.domain.people.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "viagem")
public class Viagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "data_cadastro", nullable = false)
    private Date dataCadastro;

    @NotBlank
    @Column(nullable = false)
    private Double distancia;

    @NotNull
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "veiculo_id", nullable = false, referencedColumnName = "id")
    private Veiculo veiculo;

    @NotNull
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "usuario_id", nullable = false, referencedColumnName = "id")
    private Usuario usuario;

    @NotNull
    @OneToOne
    @JsonManagedReference
    @JoinColumn(name = "endereco_origem_id", nullable = false, referencedColumnName = "id", unique = true)
    private Endereco enderecoOrigem;

    @NotNull
    @OneToOne
    @JsonManagedReference
    @JoinColumn(name = "endereco_destino_id", nullable = false, referencedColumnName = "id", unique = true)
    private Endereco enderecoDestino;

    @PrePersist
    protected void onCreate() {
        dataCadastro = new Date();
    }
}
