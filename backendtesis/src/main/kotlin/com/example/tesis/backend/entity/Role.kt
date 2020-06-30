package com.example.tesis.backend.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "roles")
data class Role (

        @Id
        @Column(name = "CROL")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val crole: Int? = null,

        @Column(name = "DESCRIPCION_ROL")
        val roleDescription : String? = "",

        @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
        @JsonIgnore
        val lstUserRole: List<UserRoles> = emptyList()
)