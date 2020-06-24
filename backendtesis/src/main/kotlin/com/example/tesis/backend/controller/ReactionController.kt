package com.example.tesis.backend.controller

import com.example.tesis.backend.repository.ReactionRepository
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin("*")
@RequestMapping("/reaction")
@RestController
class ReactionController(private val reactionRepository: ReactionRepository) {

}