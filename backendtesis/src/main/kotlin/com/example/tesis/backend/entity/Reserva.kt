package com.example.tesis.backend.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "reserva")
data class Reserva (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val creserva: Int? = null,

        @Column(name = "FRESERVA")
        val freserva: Date? = null,

        @Column(name = "DESCRIPCION")
        val descripcion: String? = "",

        @Column(name = "DIRECCION_RESERVA")
        val direccionReserva: String? = "",

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "cusuario", referencedColumnName="cusuario")
        var user: Usuario? = null
)