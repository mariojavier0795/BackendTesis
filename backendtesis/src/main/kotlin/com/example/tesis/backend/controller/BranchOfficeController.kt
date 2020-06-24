package com.example.tesis.backend.controller

import com.example.tesis.backend.repository.BranchOfficeRepository
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin("*")
@RequestMapping("/branchOffice")
@RestController
class BranchOfficeController(private val branchOfficeRepository: BranchOfficeRepository) {

}