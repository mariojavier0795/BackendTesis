package com.example.tesis.backend.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "ttiposdocumentos")
data class TypeDocuments(
        @Id
        @Column(name = "CTIPODOCUMENTOS")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val ctipoDocuments : Int? = null,

        @Column(name = "NOMBREDOCUMENTO")
        val nameDocuments : String? = "",

        @JsonIgnore
        @OneToMany(mappedBy = "typeDocuments", fetch = FetchType.LAZY)
        val lstTypeDocumentsDetail : List<TypeDocumentsDetail> = emptyList(),

        @JsonIgnore
        @OneToMany(mappedBy = "typeDocuments", fetch = FetchType.LAZY)
        val lstImagenes : List<Imagenes> = emptyList()
)