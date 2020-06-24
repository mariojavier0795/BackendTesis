package com.example.tesis.backend.controller

import com.example.tesis.backend.repository.ImagenRepository
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin("*")
@RequestMapping("/imagen")
@RestController
class ImagenController(private val imagenRepository: ImagenRepository) {

}