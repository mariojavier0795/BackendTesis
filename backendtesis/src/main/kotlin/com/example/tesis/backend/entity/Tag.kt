package com.example.tesis.backend.entity

import javax.persistence.*

@Entity
@Table(name = "etiquetas")
data class Tag (

        @Id
        @Column(name = "CETIQUETAS")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val ctag: Int? = null,

        @Column(name = "NOMBRE_ETIQUETA")
        val tagName : String? = "",

        @OneToMany(mappedBy = "tag", fetch = FetchType.LAZY)
        val lstServiceTag : List<ServiceTag> = emptyList()
)