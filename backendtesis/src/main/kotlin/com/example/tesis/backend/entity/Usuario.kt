package com.example.tesis.backend.entity

import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
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
        @ManyToOne
        @JoinColumn(name = "CPERSONA")
        var person: Persona? = null,
        @ManyToOne
        @JoinColumn(name = "CTIPOUSUARIO")
        var tipoUsuario: TipoUsuario? = null
)