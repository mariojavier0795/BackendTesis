package com.example.tesis.backend.controller

import com.example.tesis.backend.repository.ServiceTagRepository
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/serviceTag")
@RestController
class ServiceTagController(private val serviceTagRepository: ServiceTagRepository) {

}