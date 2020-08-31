package com.example.tesis.backend.service

import com.example.tesis.backend.entity.ReactionService
import com.example.tesis.backend.repository.ReactionServiceRepository
import org.springframework.stereotype.Service

@Service
class ReactionServiceService (private val reactionServiceRepository: ReactionServiceRepository) {

    fun findReactionServiceByService(service: com.example.tesis.backend.entity.Service?): List<ReactionService?>? {
        return reactionServiceRepository.findReactionServiceByService(service)
    }
}