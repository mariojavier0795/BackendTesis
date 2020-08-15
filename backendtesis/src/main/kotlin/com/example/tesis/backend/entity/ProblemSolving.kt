package com.example.tesis.backend.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name = "solucionproblemas")
data class ProblemSolving (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "CSOLUCIONPROBLEMAS")
        val cproblemSolving : Int? = null,

        @Column(name = "DESCRIPCION_SOLUCION")
        val descriptionProblem : String? = "",

        @JsonBackReference
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CPROBLEMASERVICIOARREGLAR", referencedColumnName = "CPROBLEMASERVICIOARREGLAR")
        val serviceProblemFix : ServiceProblemFix? = null
)