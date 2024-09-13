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
@Table(name = "viajes")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Viaje implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "usuario_id")
    private Long usuarioId;
    @NotNull
    @Column(name = "vehiculo_conductor_id")
    private Long vehiculoConductorId;
    @NotNull
    private int asientos;
    @NotNull
    private int paquetes;
    @NotNull
    @Column(name = "cliente_id")
    private Long clienteId;
    @NotNull
    @Column(name = "paradero_origen_id")
    private int paraderoOrigenId;
    @NotNull
    @Column(name = "paradero_destino_id")
    private int paraderoDestinoId;
    @NotBlank
    @Size(min = 1, max = 1)
    private String tabla;
    @NotNull
    private float tiempo;
    @NotNull
    private float distancia;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime creado;
    private boolean estatus;
    @NotNull
    @Column(name = "ruta_id")
    private Long rutaId;
}
