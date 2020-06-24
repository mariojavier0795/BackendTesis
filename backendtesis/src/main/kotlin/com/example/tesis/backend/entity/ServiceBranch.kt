package com.example.tesis.backend.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "serviciosucursales")
data class ServiceBranch (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "CSERVICIOSUCURSAL")
        var cserviceBranch : Int? = null,

        @OneToMany(mappedBy = "serviceBranch", fetch = FetchType.LAZY)
        @JsonIgnore()
        var lstReservation : List<Reservation> = emptyList(),

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CSERVICIO", referencedColumnName = "CSERVICIO")
        var service : Service? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CSUCURSAL", referencedColumnName = "CSUCURSAL")
        var branchOffice : BranchOffice? = null
)