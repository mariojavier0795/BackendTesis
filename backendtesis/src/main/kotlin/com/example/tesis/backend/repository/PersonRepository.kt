package com.example.tesis.backend.repository

import com.example.tesis.backend.entity.Persona
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : JpaRepository<Persona, Long>{

    @Async
    @Query("FROM Persona p where p.nombres = :name or p.apellidos = :lastname")
    fun findByNameOrLastname (@Param("name") name : String, @Param("lastname") lastname : String) : List<Persona>
}