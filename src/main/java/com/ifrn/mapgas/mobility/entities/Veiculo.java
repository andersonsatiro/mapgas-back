package com.ifrn.mapgas.mobility.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "veiculo")
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 100, unique = true)
    private String modelo;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String porte;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String marca;

    @NotNull
    @Min(0)
    @Column(nullable = false)
    private Double consumo;

    @NotBlank
    @Column(name = "tipo_combustivel", nullable = false, length = 50)
    private String tipoCombustivel;
}
