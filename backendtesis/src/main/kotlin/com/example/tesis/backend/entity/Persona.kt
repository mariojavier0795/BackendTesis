package com.example.tesis.backend.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "persona")
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
        val direccion: String = "",

        @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
        @JsonIgnore
        val user: List<Usuario> = emptyList()
)