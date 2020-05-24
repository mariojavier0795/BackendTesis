package com.example.tesis.backend.entity

import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
data class TipoUsuario (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val ctipoUsuario: Int? = null,
        @get: NotBlank
        val descripcion: String = "",
        @OneToMany(mappedBy = "tipousuario", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        var user: List<Usuario> = emptyList()
)