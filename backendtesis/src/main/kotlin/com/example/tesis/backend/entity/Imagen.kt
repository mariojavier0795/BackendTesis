package com.example.tesis.backend.entity

import javax.persistence.*

@Entity
@Table(name = "imagenes")
data class Imagen (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "CIMAGEN")
        var cimagen : Int? = null,

        @Lob
        @Column(name = "IMAGEN")
        var image : ByteArray? = null,

        @Column(name = "DESCRIPCION_IMAGEN")
        var descriptionImagen : String? = "",

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CSERVICIO", referencedColumnName = "CSERVICIO")
        var service : Service? = null

)