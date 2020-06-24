package com.example.tesis.backend.repository

import com.example.tesis.backend.entity.Reaction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReactionRepository : JpaRepository<Reaction, Long> {
}