package com.example.tesis.backend.entity

import javax.persistence.*

@Entity
@Table(name = "rolesusuario")
data class UserRoles (

        @Id
        @Column(name = "CROLUSUARIO")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var cuserRole: Int? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CROL", referencedColumnName="CROL")
        var role: Role? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CUSUARIO", referencedColumnName="CUSUARIO")
        var user: User? = null
)