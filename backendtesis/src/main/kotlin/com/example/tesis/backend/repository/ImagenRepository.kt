package com.example.tesis.backend.repository

import com.example.tesis.backend.entity.Imagen
import com.example.tesis.backend.entity.Service
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ImagenRepository : JpaRepository<Imagen, Long> {

    @Query("FROM Imagen where service = :pservice")
    fun findImagebyService(@Param("pservice") service: Service?): List<Imagen?>?
}