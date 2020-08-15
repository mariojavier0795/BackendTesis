package com.example.tesis.backend.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "usuario")
data class User (

        @Id
        @Column(name = "CUSUARIO")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val cuser: Int? = null,

        @Column(name = "USUARIO")
        val username : String? = "",

        @Column(name = "CORREO")
        val mail : String? = "",

        @Column(name = "PASSWORD")
        var password : String? = "",

        @Column(name = "NOMBRES")
        val names : String? = "",

        @Column(name = "APELLIDOS")
        val lastnames : String? = "",

        @Column(name = "EDAD")
        val age : Int? = null,

        @Column(name = "FNACIMIENTO")
        val birthDay : Date? = null,

        @Column(name = "SEXO")
        val gender : String? = "",

        @Column(name = "TELEFONO")
        val phone : String? = "",

        @Lob()
        @Column(name = "IMAGEN_USUARIO")
        val userImage : ByteArray? = null,

        @JsonIgnore
        @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
        val lstUserRole : List<UserRoles> = emptyList(),

        @JsonIgnore
        @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
        val lstCommentary : List<Commentary> = emptyList(),

        @JsonIgnore
        @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
        val lstService : List<Service> = emptyList(),

        @JsonIgnore
        @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
        val lstReservation : List<Reservation> = emptyList()
)