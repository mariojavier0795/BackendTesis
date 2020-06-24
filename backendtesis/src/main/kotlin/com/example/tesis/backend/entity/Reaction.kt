package com.example.tesis.backend.entity

import javax.persistence.*

@Entity
@Table(name = "reaccion")
data class Reaction (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "CREACCION")
        var creaction : Int? = null,

        @Column(name = "NOMBRE_REACCION")
        var reactionName : String? = "",

        @Lob
        @Column(name = "IMAGEN_REACCION")
        var reactionImagen : List<Byte> = emptyList(),

        @OneToMany(mappedBy = "reaction", fetch = FetchType.LAZY)
        var lstReactionService : List<ReactionService> = emptyList()
)