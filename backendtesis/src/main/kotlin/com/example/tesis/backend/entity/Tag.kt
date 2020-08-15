package com.example.tesis.backend.entity

import com.fasterxml.jackson.annotation.JsonIgnore
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

        @JsonIgnore()
        @OneToMany(mappedBy = "tag", fetch = FetchType.LAZY)
        val lstServiceTag : List<ServiceTag> = emptyList()
)