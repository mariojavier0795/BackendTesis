package com.example.tesis.backend.entity

import javax.persistence.*

@Entity
@Table(name = "categoriaservicios")
data class ServicesCategory (

        @Id
        @Column(name = "CCATEGORIASERVICIOS")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var cservicesCategory: Int? = null,

        @Column(name = "NOMBRE_CATEGORIA")
        var categoryName : String? = ""
)