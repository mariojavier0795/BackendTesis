package com.example.tesis.backend.controller

import com.example.tesis.backend.entity.Tag
import com.example.tesis.backend.repository.TagRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin("*")
@RequestMapping("/tag")
@RestController
class TagController(private val tagRepository: TagRepository) {

    @GetMapping("/prueba")
    fun test(): ResponseEntity<List<Tag?>?> {
        return ResponseEntity.ok(tagRepository.findAll())
    }
}