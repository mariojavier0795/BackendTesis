package com.example.tesis.backend.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "comentario")
data class Commentary (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "CCOMENTARIO")
        var ccommentary : Int? = null,

        @Column(name = "DESCRIPCION_COMENTARIO")
        var descriptionComment : String? = "",

        @Column(name = "FCOMENTARIO")
        var fcomment : Date? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CSERVICIO", referencedColumnName = "CSERVICIO")
        var service : Service? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CUSUARIO", referencedColumnName = "CUSUARIO")
        var user : User? = null
)