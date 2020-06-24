package com.example.tesis.backend.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import java.sql.Blob
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "usuario")
data class User (

        @Id
        @Column(name = "CUSUARIO")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var cuser: Int? = null,

        @Column(name = "USUARIO")
        var username : String? = "",

        @Column(name = "CORREO")
        var mail : String? = "",

        @Column(name = "PASSWORD")
        var password : String? = "",

        @Column(name = "NOMBRES")
        var names : String? = "",

        @Column(name = "APELLIDOS")
        var lastnames : String? = "",

        @Column(name = "EDAD")
        var age : Int? = null,

        @Column(name = "FNACIMIENTO")
        var birthDay : Date? = null,

        @Column(name = "SEXO")
        var gender : String? = "",

        @Column(name = "TELEFONO")
        var phone : String? = "",

        @Lob
        @Column(name = "IMAGEN_USUARIO")
        var userImage : Blob? = null,

        @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
        @JsonIgnore
        var lstUserRole: List<UserRoles> = emptyList()
)