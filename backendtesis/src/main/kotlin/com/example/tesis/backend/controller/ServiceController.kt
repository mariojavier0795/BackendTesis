package com.example.tesis.backend.controller

import com.example.tesis.backend.entity.Service
import com.example.tesis.backend.entity.User
import com.example.tesis.backend.service.ServiceService
import org.springframework.web.bind.annotation.*

@CrossOrigin("*")
@RequestMapping("/service")
@RestController
class ServiceController(private val serviceService: ServiceService) {
    @PostMapping("/getService")
    fun getService(@RequestBody user: User): List<Service>? {
        return serviceService.findServicebyUsername(user)
    }
}