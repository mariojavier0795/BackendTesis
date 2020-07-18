package com.example.tesis.backend.controller

import com.example.tesis.backend.repository.ServiceProblemFixRepository
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/serviceProblemFix")
@RestController
class ServiceProblemFixController(private val serviceProblemFixRepository: ServiceProblemFixRepository) {

}