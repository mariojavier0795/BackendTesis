package com.example.tesis.backend.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
@Table(name = "problemaservicioarreglar")
data class ServiceProblemFix (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "CPROBLEMASERVICIOARREGLAR")
        val cserviceProblemFix : Int? = null,

        @Column(name = "DESCRIPCION_PROBLEMA")
        val descriptionProblem : String? = "",

        @JsonManagedReference
        @OneToMany(mappedBy = "serviceProblemFix", fetch = FetchType.LAZY)
        val lstProblemSolving : List<ProblemSolving> = emptyList(),

        @JsonIgnore
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CSERVICIO", referencedColumnName = "CSERVICIO")
        val service : Service? = null
)