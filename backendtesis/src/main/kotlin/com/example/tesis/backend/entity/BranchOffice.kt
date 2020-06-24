package com.example.tesis.backend.entity

import javax.persistence.*

@Entity
@Table(name = "sucursal")
data class BranchOffice (

        @Id
        @Column(name = "CSUCURSAL")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var cbranchOffice : Int? = null,

        @Column(name = "LATITUD_SUCURSAL")
        var latitudeBranchOffice : Float? = null,

        @Column(name = "LONGITUD_SUCURSAL")
        var longitudeBranchOffice : Float? = null,

        @Column(name = "NOMBRE_SUCURSAL")
        var nameBranchOffice : String? = "",

        @OneToMany(mappedBy = "branchOffice", fetch = FetchType.LAZY)
        var lstServiceBranch : List<ServiceBranch> = emptyList()
)