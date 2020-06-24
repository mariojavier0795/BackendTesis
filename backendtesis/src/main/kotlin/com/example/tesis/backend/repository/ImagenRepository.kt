package com.example.tesis.backend.repository

import com.example.tesis.backend.entity.Imagen
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ImagenRepository : JpaRepository<Imagen, Long> {
}