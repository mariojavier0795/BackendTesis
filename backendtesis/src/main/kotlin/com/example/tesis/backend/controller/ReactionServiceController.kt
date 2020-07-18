package com.example.tesis.backend.controller

import com.example.tesis.backend.repository.ReactionServiceRepository
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/reactionService")
@RestController
class ReactionServiceController(private val reactionServiceRepository: ReactionServiceRepository) {

}