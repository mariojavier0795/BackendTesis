package com.example.tesis.backend.entity

import javax.persistence.*

@Entity
@Table(name = "timagenes")
data class Imagenes (
        @Id
        @Column(name = "CIMAGEN")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val cimagen: Int? = null,

        @Lob
        @Column(name = "IMAGEN")
        val imagen : ByteArray? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CTIPODOCUMENTOS", referencedColumnName = "CTIPODOCUMENTOS")
        val typeDocuments: TypeDocuments? = null
)