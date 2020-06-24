package com.example.tesis.backend.controller

import com.example.tesis.backend.repository.ServicesCategoryRepository
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin("*")
@RequestMapping("/servicesCategory")
@RestController
class ServicesCategoryController(private val servicesCategoryRepository: ServicesCategoryRepository) {

}