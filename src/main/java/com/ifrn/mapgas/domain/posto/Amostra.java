package com.ifrn.mapgas.domain.posto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ifrn.mapgas.domain.people.Admin;
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
@Table(name = "amostra")
public class Amostra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Min(0)
    @Column(name = "densidade", nullable = false)
    private Double densidade;

    @NotNull
    @Min(0)
    @Column(name = "teor_etanol", nullable = false)
    private Double teorEtanol;

    @NotNull
    @Min(0)
    @Column(name = "eficiencia_final", nullable = false)
    private Double eficienciaFinal;

    @NotNull
    @Column(name = "data_cadastro", nullable = false)
    private Date dataCadastro;

    @NotNull
    @Column(name = "data_coleta", nullable = false)
    private Date dataColeta;

    @NotNull
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "posto_id", nullable = false, referencedColumnName = "id")
    private Posto posto;

    @NotNull
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "admin_id", nullable = false, referencedColumnName = "id")
    private Admin admin;

    @PrePersist
    protected void onCreate() { dataCadastro = new Date(); }
}
