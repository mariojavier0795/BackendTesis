package com.example.tesis.backend.controller

import com.example.tesis.backend.entity.ServiceTag
import com.example.tesis.backend.repository.ServiceTagRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin("*")
@RequestMapping("/serviceTag")
@RestController
class ServiceTagController(private val serviceTagRepository: ServiceTagRepository) {

    @GetMapping("/prueba")
    fun test(): ResponseEntity<List<ServiceTag?>?> {
        return ResponseEntity.ok(serviceTagRepository.findAll())
    }
}