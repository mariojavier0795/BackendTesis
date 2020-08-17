package com.example.tesis.backend.controller

import com.example.tesis.backend.entity.ProblemSolving
import com.example.tesis.backend.repository.ProblemSolvingRepository
import com.example.tesis.backend.service.ProblemSolvingService
import com.example.tesis.backend.structure.JsonStructure
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin("*")
@RequestMapping("/problemSolving")
@RestController
class ProblemSolvingController(private val problemSolvingService: ProblemSolvingService) {

    @PostMapping("findProblemByUsername")
    fun findProblemByUsername(@RequestBody jsonStructure: JsonStructure?): ResponseEntity<List<ProblemSolving?>?> {
        val responseListProblemSolving = problemSolvingService.findProblemSolvingByUsername(jsonStructure?.user)
        return ResponseEntity.ok(responseListProblemSolving!!)
    }

    @PostMapping("findProblemById")
    fun findProblemById(@RequestBody jsonStructure: JsonStructure?) : ResponseEntity<ProblemSolving?>{
        val responseProblemSolving = problemSolvingService.findProblemSolvingById(jsonStructure?.problemSolving)
        return ResponseEntity.ok(responseProblemSolving!!)
    }

    @PostMapping("insertProblem")
    fun insertProblem(@RequestBody jsonStructure: JsonStructure?): ResponseEntity<Boolean> {
        val result = problemSolvingService.insertProblemSolving(jsonStructure?.problemSolving)
        return ResponseEntity.ok(result)
    }

    @PostMapping("deleteProblem")
    fun deleteProblem(@RequestBody jsonStructure: JsonStructure?): ResponseEntity<Boolean> {
        val result = problemSolvingService.deleteProblemSolving(jsonStructure?.problemSolving)
        return ResponseEntity.ok(result)
    }
}