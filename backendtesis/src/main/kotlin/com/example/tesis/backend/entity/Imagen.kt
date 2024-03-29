package com.example.tesis.backend.entity

import javax.persistence.*

@Entity
@Table(name = "imagenes")
data class Imagen (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "CIMAGEN")
        val cimagen : Int? = null,

        @Lob
        @Column(name = "IMAGEN")
        val image : ByteArray? = null,

        @Column(name = "DESCRIPCION_IMAGEN")
        val descriptionImagen : String? = "",

        @Column(name = "TIPOARCHIVO")
        val filetype: String? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CSERVICIO", referencedColumnName = "CSERVICIO")
        var service : Service? = null

)