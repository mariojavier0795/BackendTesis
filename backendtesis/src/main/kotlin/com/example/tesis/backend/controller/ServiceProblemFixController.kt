package com.example.tesis.backend.controller

import com.example.tesis.backend.entity.ServiceProblemFix
import com.example.tesis.backend.service.ServiceProblemFixService
import com.example.tesis.backend.structure.JsonStructure
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin("*")
@RequestMapping("/serviceProblemFix")
@RestController
class ServiceProblemFixController(private val serviceProblemFixService: ServiceProblemFixService) {

    @PostMapping("deleteServiceProblemFix")
    fun deleteServiceProblemFix(@RequestBody jsonRequest: JsonStructure?): ResponseEntity<Boolean> {
        val result = serviceProblemFixService.deleteServiceProblemFixService(jsonRequest?.serviceProblemFix)
        return ResponseEntity.ok(result)
    }

    @PostMapping("insertServiceProblemFix")
    fun insertServiceProblemFix(@RequestBody jsonStructure: JsonStructure?): ResponseEntity<Boolean> {
        val result = serviceProblemFixService.insertServiceProblemFixService(jsonStructure?.serviceProblemFix)
        return ResponseEntity.ok(result)
    }

    @PostMapping("findServiceProblemFixById")
    fun findServiceProblemFixById(@RequestBody jsonStructure: JsonStructure?): ResponseEntity<JsonStructure?> {
        val result = serviceProblemFixService.findServiceProblemFixServicebyId(jsonStructure?.serviceProblemFix)
        return ResponseEntity.ok(JsonStructure(null, null, null, null, null, null,
                null, null, null, null, null, result, null,
                null, null, null, null))
    }

    @PostMapping("findServiceProblemFixByUsername")
    fun findServiceProblemFixByUsername(@RequestBody jsonStructure: JsonStructure?): ResponseEntity<List<ServiceProblemFix?>?> {
        val listProblemFix = serviceProblemFixService.findServiceProblemFixByUser(jsonStructure?.user)
        return ResponseEntity.ok(listProblemFix!!)
    }
}