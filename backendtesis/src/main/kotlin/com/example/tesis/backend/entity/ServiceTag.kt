package com.example.tesis.backend.entity

import javax.persistence.*

@Entity
@Table(name = "servicioetiquetas")
data class ServiceTag (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "CSERVICIOETIQUETA")
        val cserviceTag : Int? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CSERVICIO", referencedColumnName = "CSERVICIO")
        val service : Service? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CETIQUETAS", referencedColumnName = "CETIQUETAS")
        val tag : Tag? = null

)