package com.example.tesis.backend.controller

import com.example.tesis.backend.repository.ServiceBranchRepository
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin("*")
@RequestMapping("/serviceBranch")
@RestController
class ServiceBranchController(private val serviceBranchRepository: ServiceBranchRepository) {

}