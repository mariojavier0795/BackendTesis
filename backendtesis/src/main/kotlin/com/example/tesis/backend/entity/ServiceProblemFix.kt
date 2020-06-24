package com.example.tesis.backend.entity

import javax.persistence.*

@Entity
@Table(name = "problemaservicioarreglar")
data class ServiceProblemFix (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "CPROBLEMASERVICIOARREGLAR")
        var cserviceProblemFix : Int? = null,

        @Column(name = "DESCRIPCION_PROBLEMA")
        var descriptionProblem : String? = "",

        @OneToMany(mappedBy = "serviceProblemFix", fetch = FetchType.LAZY)
        var lstProblemSolving : List<ProblemSolving> = emptyList(),

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CSERVICIO", referencedColumnName = "CSERVICIO")
        var service : Service? = null
)