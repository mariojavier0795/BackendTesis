package com.example.tesis.backend.controller

import com.example.tesis.backend.repository.ProblemSolvingRepository
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin("*")
@RequestMapping("/problemSolving")
@RestController
class ProblemSolvingController(private val problemSolvingRepository: ProblemSolvingRepository) {

}