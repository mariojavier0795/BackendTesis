package com.example.tesis.backend.repository

import com.example.tesis.backend.entity.Imagenes
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ImagenesRepository: JpaRepository<Imagenes, Long> {

    @Query("FROM Imagenes where cimagen = :pcimagen")
    fun getImagen(@Param("pcimagen") pcimagen: Int?): Imagenes?

}