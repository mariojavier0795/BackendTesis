package com.example.tesis.backend.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "serviciosucursales")
data class ServiceBranch (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "CSERVICIOSUCURSAL")
        val cserviceBranch : Int? = null,

        @JsonIgnore
        @OneToMany(mappedBy = "serviceBranch", fetch = FetchType.LAZY)
        val lstReservation : List<Reservation> = emptyList(),

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CSERVICIO", referencedColumnName = "CSERVICIO")
        val service : Service? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CSUCURSAL", referencedColumnName = "CSUCURSAL")
        val branchOffice : BranchOffice? = null
)