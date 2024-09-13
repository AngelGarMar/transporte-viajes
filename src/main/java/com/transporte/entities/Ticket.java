package com.transporte.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private int asiento;
    @NotNull
    private double costo;
    @Size(min = 0, max = 200)
    private String nota;
    @NotNull
    private float peso;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime creado;
    private boolean estatus;
    @ManyToOne
    @JoinColumn(name = "boleto_id")
    private Boleto boleto;
    @ManyToOne
    @JoinColumn(name = "tipo_ticket_id")
    private TipoTicket tipoTicket;
}
