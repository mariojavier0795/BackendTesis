package com.example.tesis.backend.controller

import com.example.tesis.backend.repository.TagRepository
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/branchOffice")
@RestController
class TagController(private val tagRepository: TagRepository) {

}