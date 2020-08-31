package com.example.tesis.backend.entity

import javax.persistence.*

@Entity
@Table(name = "ttiposdocumentosdetalle")
data class TypeDocumentsDetail (
        @Id
        @Column(name = "CTIPODOCUMENTOSDETALLE")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val ctipoDocumentsDetail: Int? = null,

        @Column(name = "NOMBRECOLUMNA")
        val nameColumn : String? = "",

        @Column(name = "VALORPARAMETRIZACION")
        val valueParametered : String? = "",

        @Column(name = "VALOROCR")
        val valueOCR : String? = "",

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CTIPODOCUMENTOS", referencedColumnName = "CTIPODOCUMENTOS")
        val typeDocuments: TypeDocuments? = null

)