package com.example.tesis.backend.repository

import com.example.tesis.backend.entity.Persona
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : JpaRepository<Persona, Long>{
}