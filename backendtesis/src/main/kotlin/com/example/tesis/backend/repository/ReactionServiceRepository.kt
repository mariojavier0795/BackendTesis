package com.example.tesis.backend.repository

import com.example.tesis.backend.entity.ReactionService
import com.example.tesis.backend.entity.Service
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ReactionServiceRepository : JpaRepository<ReactionService, Long> {

    @Query("FROM ReactionService where service = :pservice")
    fun findReactionServiceByService(@Param("pservice") service: Service?): List<ReactionService?>?
}