package com.ifrn.mapgas.people.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ifrn.mapgas.mobility.entities.Veiculo;
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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 30, unique = true)
    private String usuario;

    @NotBlank
    @Email
    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String senha;

    @NotNull
    @Column(nullable = false)
    private Boolean ativo;

    @NotNull
    @Column(name = "data_cadastro", nullable = false)
    private Date dataCadastro;

    @NotNull
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "tipo_usuario_id", nullable = false, referencedColumnName = "id")
    private TipoUsuario tipoUsuario;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "veiculo_id", referencedColumnName = "id")
    private Veiculo veiculo;

    @NotNull
    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "pessoa_id", nullable = false, referencedColumnName = "id")
    private Pessoa pessoa;

    @PrePersist
    protected void onCreate() {
        dataCadastro = new Date();
    }
}
