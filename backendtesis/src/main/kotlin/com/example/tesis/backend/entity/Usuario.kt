package com.example.tesis.backend.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "usuario")
data class Usuario (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val cusuario: Int? = null,

        @get: NotBlank
        val usuario: String = "",

        @get: NotBlank
        val correo: String = "",

        @get: NotBlank
        val password: String? = "",

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "cpersona", referencedColumnName="cpersona")
        var person: Persona? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "ctipousuario", referencedColumnName="ctipousuario")
        var tipoUsuario: TipoUsuario? = null,

        @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
        var booking: List<Reserva> = emptyList()
)