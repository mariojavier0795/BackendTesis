package com.example.tesis.backend.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "servicio")
data class Service (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "CSERVICIO")
        val cservice : Int? = null,

        @Column(name = "NOMBRE_SERVICIO")
        val serviceName : String? = "",

        @Column(name = "DESCRIPCION")
        val description : String? = "",

        @Column(name = "PRECIO_UNITARIO")
        val unitPrice : Float? = null,

        @Column(name = "FSERVICIO")
        val serviceDate : Date? = null,

        @Column(name = "ALIAS_SERVICIO")
        val serviceAlias : String? = "",

        @Column(name = "NUMERO_CALIFICACIONES")
        val numberRatings : Int? = null,

        @Column(name = "CALIFICACION_SERVICIO")
        val serviceQualification : Int? = null,

        @Column(name = "DOMICILIO")
        val homeservice : Boolean? = null,

        @JsonIgnore
        @OneToMany(mappedBy = "service", fetch = FetchType.LAZY)
        val lstServiceTag : List<ServiceTag> = emptyList(),

        @JsonIgnore
        @OneToMany(mappedBy = "service", fetch = FetchType.LAZY)
        val lstServiceBranch : List<ServiceBranch> = emptyList(),

        @JsonIgnore
        @OneToMany(mappedBy = "service", fetch = FetchType.LAZY)
        val lstCommentary : List<Commentary> = emptyList(),

        @JsonIgnore
        @OneToMany(mappedBy = "service", fetch = FetchType.LAZY)
        val lstServiceProblemFix : List<ServiceProblemFix> = emptyList(),

        @JsonIgnore
        @OneToMany(mappedBy = "service", fetch = FetchType.LAZY)
        val lstImagen : List<Imagen> = emptyList(),

        @JsonIgnore
        @OneToMany(mappedBy = "service", fetch = FetchType.LAZY)
        val lstReactionService : List<ReactionService> = emptyList(),

        @JsonIgnore
        @OneToMany(mappedBy = "service", fetch = FetchType.LAZY)
        val lstReservation : List<Reservation> = emptyList(),

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CUSUARIO", referencedColumnName = "CUSUARIO")
        val user : User? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CCATEGORIASERVICIOS", referencedColumnName="CCATEGORIASERVICIOS")
        val servicesCategory: ServicesCategory? = null
)