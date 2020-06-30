package com.example.tesis.backend.entity

import javax.persistence.*

@Entity
@Table(name = "rolesusuario")
data class UserRoles (

        @Id
        @Column(name = "CROLUSUARIO")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val cuserRole: Int? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CROL", referencedColumnName="CROL")
        val role: Role? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CUSUARIO", referencedColumnName="CUSUARIO")
        val user: User? = null
)