package com.example.tesis.backend.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "tipoestados")
data class TipoEstados (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val ctipoestado: Int? = null,

        @Column(name = "DESCRIPCION")
        val descripcion: String = ""
)