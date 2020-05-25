package com.example.tesis.backend.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "tipousuario")
data class TipoUsuario (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val ctipousuario: Int? = null,
        @get: NotBlank
        val descripcion: String = "",
        @OneToMany(mappedBy = "tipoUsuario", fetch = FetchType.LAZY)
        @JsonIgnore
        var user: List<Usuario> = emptyList()
)