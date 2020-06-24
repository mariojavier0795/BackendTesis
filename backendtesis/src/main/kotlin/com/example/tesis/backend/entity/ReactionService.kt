package com.example.tesis.backend.entity

import javax.persistence.*

@Entity
@Table(name = "reaccionservicio")
data class ReactionService (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "CREACCIONSERVICIO")
        var creactionService : Int? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CSERVICIO", referencedColumnName = "CSERVICIO")
        var service : Service? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CREACCION", referencedColumnName = "CREACCION")
        var reaction : Reaction? = null
)