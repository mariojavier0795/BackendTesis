package com.example.tesis.backend.repository


import com.example.tesis.backend.entity.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<Usuario, Long>{
}