package com.example.tesis.backend.controller

import com.example.tesis.backend.repository.CommentaryRepository
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin("*")
@RequestMapping("/commentary")
@RestController
class CommentaryController (private val commentaryRepository: CommentaryRepository) {

}