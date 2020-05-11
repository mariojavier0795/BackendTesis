package com.example.tesis.backend

import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
data class Persona (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val cpersona: Int? = null,
        @get: NotBlank
        val nombres: String = "",
        @get: NotBlank
        val apellidos: String = "",
        @get: NotBlank
        val edad: Int? = null,
        @get: NotBlank
        val fnacimiento: Date? = null,
        @get: NotBlank
        val sexo: String = "",
        @get: NotBlank
        val telefono: String = "",
        @get: NotBlank
        val direccion: String = ""
)