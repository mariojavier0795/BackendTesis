package com.example.tesis.backend.controller

import com.example.tesis.backend.repository.ServiceRepository
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin("*")
@RequestMapping("/service")
@RestController
class ServiceController(private val serviceRepository: ServiceRepository) {

}