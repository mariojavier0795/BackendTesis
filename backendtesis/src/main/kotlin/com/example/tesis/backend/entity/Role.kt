package com.example.tesis.backend.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "roles")
data class Role (

        @Id
        @Column(name = "CROL")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var crole: Int? = null,

        @Column(name = "DESCRIPCION_ROL")
        var roleDescription : String? = "",

        @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
        @JsonIgnore
        var lstUserRole: List<UserRoles> = emptyList()
)