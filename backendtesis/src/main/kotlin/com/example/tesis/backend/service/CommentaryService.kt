package com.example.tesis.backend.service

import com.example.tesis.backend.entity.Commentary
import com.example.tesis.backend.repository.CommentaryRepository
import org.springframework.stereotype.Service

@Service
class CommentaryService(private val commentaryRepository: CommentaryRepository) {

    fun findCommentaryByService(service: com.example.tesis.backend.entity.Service?): List<Commentary?>? {
        return commentaryRepository.findCommentaryByService(service)
    }
}