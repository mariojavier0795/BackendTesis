package com.example.tesis.backend.controller

import com.example.tesis.backend.entity.Service
import com.example.tesis.backend.entity.User
import com.example.tesis.backend.service.ServiceService
import com.example.tesis.backend.structure.JsonStructure
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin("*")
@RequestMapping("/service")
@RestController
class ServiceController(private val serviceService: ServiceService) {

    @PostMapping("/getServiceByUser")
    fun getService(@RequestBody jsonRequest: JsonStructure?): ResponseEntity<List<Service>?> {
        return ResponseEntity.ok(serviceService.findServicebyUsername(jsonRequest?.user)!!)
    }

    @PostMapping("/deleteServicebyId")
    fun deleteServicebyId(@RequestBody jsonRequest: JsonStructure?): ResponseEntity<Boolean> {
        serviceService.deleteServicebyId(jsonRequest?.service)
        return ResponseEntity.ok(true)
    }

    @PostMapping("/getServiceById")
    fun getServiceById(@RequestBody jsonRequest: JsonStructure?): ResponseEntity<Service?> {
        return ResponseEntity.ok(serviceService.findServicebyId(jsonRequest?.service)!!)
    }

    @PostMapping("/updateService")
    fun updateService(@RequestBody jsonRequest: JsonStructure?): ResponseEntity<Boolean> {
        val flagUpdate = serviceService.updateService(jsonRequest?.service)
        return ResponseEntity.ok(flagUpdate)
    }
}