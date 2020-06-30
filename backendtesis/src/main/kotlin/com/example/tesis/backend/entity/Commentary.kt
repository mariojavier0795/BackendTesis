package com.example.tesis.backend.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "comentario")
data class Commentary (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "CCOMENTARIO")
        val ccommentary : Int? = null,

        @Column(name = "DESCRIPCION_COMENTARIO")
        val descriptionComment : String? = "",

        @Column(name = "FCOMENTARIO")
        val fcomment : Date? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CSERVICIO", referencedColumnName = "CSERVICIO")
        val service : Service? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CUSUARIO", referencedColumnName = "CUSUARIO")
        val user : User? = null
)