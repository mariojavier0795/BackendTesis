package com.example.tesis.backend.entity

import javax.persistence.*

@Entity
@Table(name = "etiquetas")
data class Tag (

        @Id
        @Column(name = "CETIQUETAS")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var ctag: Int? = null,

        @Column(name = "NOMBRE_ETIQUETA")
        var tagName : String? = "",

        @OneToMany(mappedBy = "tag", fetch = FetchType.LAZY)
        var lstServiceTag : List<ServiceTag> = emptyList()
)