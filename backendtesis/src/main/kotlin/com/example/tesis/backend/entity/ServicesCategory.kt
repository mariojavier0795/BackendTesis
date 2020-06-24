package com.example.tesis.backend.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "categoriaservicios")
data class ServicesCategory (

        @Id
        @Column(name = "CCATEGORIASERVICIOS")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var cservicesCategory: Int? = null,

        @Column(name = "NOMBRE_CATEGORIA")
        var categoryName : String? = "",

        @OneToMany(mappedBy = "servicesCategory", fetch = FetchType.LAZY)
        @JsonIgnore
        var lstService: List<Service> = emptyList()
)