package com.example.tesis.backend.entity

import javax.persistence.*

@Entity
@Table(name = "servicioetiquetas")
data class ServiceTag (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "CSERVICIOETIQUETA")
        var cserviceTag : Int? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CSERVICIO", referencedColumnName = "CSERVICIO")
        var service : Service? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CETIQUETAS", referencedColumnName = "CETIQUETAS")
        var tag : Tag? = null

)