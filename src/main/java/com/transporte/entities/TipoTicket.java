package com.transporte.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tipos_ticket")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TipoTicket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 1, max = 45)
    private String descripcion;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime creado;
    @Column(name = "estatus")
    private boolean estatus;
}
