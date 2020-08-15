package com.example.tesis.backend.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "categoriaservicios")
data class ServicesCategory (

        @Id
        @Column(name = "CCATEGORIASERVICIOS")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val cservicesCategory: Int? = null,

        @Column(name = "NOMBRE_CATEGORIA")
        val categoryName : String? = "",

        @JsonIgnore
        @OneToMany(mappedBy = "servicesCategory", fetch = FetchType.LAZY)
        val lstService: List<Service> = emptyList()
)