package com.example.tesis.backend.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "sucursal")
data class BranchOffice (

        @Id
        @Column(name = "CSUCURSAL")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val cbranchOffice : Int? = null,

        @Column(name = "LATITUD_SUCURSAL")
        val latitudeBranchOffice : Float? = null,

        @Column(name = "LONGITUD_SUCURSAL")
        val longitudeBranchOffice : Float? = null,

        @Column(name = "NOMBRE_SUCURSAL")
        var nameBranchOffice : String? = "",

        @JsonIgnore
        @OneToMany(mappedBy = "branchOffice", fetch = FetchType.LAZY)
        val lstServiceBranch : List<ServiceBranch> = emptyList()
)