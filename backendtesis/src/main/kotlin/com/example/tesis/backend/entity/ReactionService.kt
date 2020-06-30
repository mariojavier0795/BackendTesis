package com.example.tesis.backend.entity

import javax.persistence.*

@Entity
@Table(name = "reaccionservicio")
data class ReactionService (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "CREACCIONSERVICIO")
        val creactionService : Int? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CSERVICIO", referencedColumnName = "CSERVICIO")
        val service : Service? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CREACCION", referencedColumnName = "CREACCION")
        val reaction : Reaction? = null
)