package com.example.tesis.backend.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "servicio")
data class Service (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "CSERVICIO")
        var cservice : Int? = null,

        @Column(name = "NOMBRE_SERVICIO")
        var serviceName : String? = "",

        @Column(name = "DESCRIPCION")
        var description : String? = "",

        @Column(name = "PRECIO_UNITARIO")
        var unitPrice : Float? = null,

        @Column(name = "FSERVICIO")
        var serviceDate : Date? = null,

        @Column(name = "ALIAS_SERVICIO")
        var serviceAlias : String? = "",

        @Column(name = "NUMERO_CALIFICACIONES")
        var numberRatings : Int? = null,

        @Column(name = "CALIFICACION_SERVICIO")
        var serviceQualification : Int? = null,

        @Column(name = "DOMICILIO")
        var homeservice : Boolean? = null,

        @OneToMany(mappedBy = "service", fetch = FetchType.LAZY)
        var lstServiceTag : List<ServiceTag> = emptyList(),

        @OneToMany(mappedBy = "service", fetch = FetchType.LAZY)
        var lstServiceBranch : List<ServiceBranch> = emptyList(),

        @OneToMany(mappedBy = "service", fetch = FetchType.LAZY)
        var lstCommentary : List<Commentary> = emptyList(),

        @OneToMany(mappedBy = "service", fetch = FetchType.LAZY)
        var lstServiceProblemFix : List<ServiceProblemFix> = emptyList(),

        @OneToMany(mappedBy = "service", fetch = FetchType.LAZY)
        var lstImagen : List<Imagen> = emptyList(),

        @OneToMany(mappedBy = "service", fetch = FetchType.LAZY)
        var lstReactionService : List<ReactionService> = emptyList(),

        @OneToMany(mappedBy = "service", fetch = FetchType.LAZY)
        var lstReservation : List<Reservation> = emptyList(),

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CUSUARIO", referencedColumnName = "CUSUARIO")
        var user : User? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CCATEGORIASERVICIOS", referencedColumnName="CCATEGORIASERVICIOS")
        var servicesCategory: ServicesCategory? = null
)