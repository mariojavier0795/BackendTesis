package com.example.tesis.backend.repository

import com.example.tesis.backend.entity.ReactionService
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReactionServiceRepository : JpaRepository<ReactionService, Long> {
}