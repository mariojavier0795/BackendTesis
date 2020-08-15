package com.example.tesis.backend.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "reaccion")
data class Reaction (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "CREACCION")
        val creaction : Int? = null,

        @Column(name = "NOMBRE_REACCION")
        val reactionName : String? = "",

        @Lob
        @Column(name = "IMAGEN_REACCION")
        val reactionImagen : ByteArray? = null,

        @JsonIgnore
        @OneToMany(mappedBy = "reaction", fetch = FetchType.LAZY)
        val lstReactionService : List<ReactionService> = emptyList()
)