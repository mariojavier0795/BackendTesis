package com.example.tesis.backend.entity

import javax.persistence.*

@Entity
@Table(name = "solucionproblemas")
data class ProblemSolving (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "CSOLUCIONPROBLEMAS")
        var cproblemSolving : Int? = null,

        @Column(name = "DESCRIPCION_SOLUCION")
        var descriptionProblem : String? = "",

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CPROBLEMASERVICIOARREGLAR", referencedColumnName = "CPROBLEMASERVICIOARREGLAR")
        var serviceProblemFix : ServiceProblemFix? = null
)