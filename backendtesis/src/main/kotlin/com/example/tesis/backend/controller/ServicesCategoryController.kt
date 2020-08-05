package com.example.tesis.backend.controller

import com.example.tesis.backend.entity.ServicesCategory
import com.example.tesis.backend.repository.ServicesCategoryRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/servicesCategory")
@RestController
class ServicesCategoryController(private val servicesCategoryRepository: ServicesCategoryRepository) {

    @GetMapping("/getAllServiceCategory")
    fun getAllServiceCategory(): ResponseEntity<List<ServicesCategory?>?> {
        return ResponseEntity.ok(servicesCategoryRepository.findAll())
    }
}