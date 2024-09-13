package com.transporte.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "boletos")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Boleto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private int asientos;
    @NotBlank
    @Size(min = 1, max = 5)
    private String salida;
    @NotBlank
    @Size(min = 1, max = 5)
    private String llegada;
    @NotNull
    private double costo;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime create;
    @NotBlank
    @Size(min = 1, max = 45)
    private String nombreArchivo;
    @NotBlank
    @Size(min = 1, max = 5)
    private String extensionArchivo;
    private boolean estatus;
    @ManyToOne
    @JoinColumn(name = "viaje_id")
    private Viaje viaje;
}
