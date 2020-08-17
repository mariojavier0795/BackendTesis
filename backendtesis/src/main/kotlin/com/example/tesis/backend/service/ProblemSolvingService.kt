package com.example.tesis.backend.service

import com.example.tesis.backend.entity.ProblemSolving
import com.example.tesis.backend.entity.User
import com.example.tesis.backend.repository.ProblemSolvingRepository
import org.springframework.stereotype.Service

@Service
class ProblemSolvingService(private val problemSolvingRepository: ProblemSolvingRepository) {

    fun insertProblemSolving(problemSolvingEntity: ProblemSolving?): Boolean {
        var result = false
        if(problemSolvingEntity != null){
            problemSolvingRepository.save(problemSolvingEntity)
            result = true
        }
        return result
    }

    fun deleteProblemSolving(problemSolvingEntity: ProblemSolving?): Boolean {
        var result = false
        if(problemSolvingEntity != null){
            problemSolvingRepository.delete(problemSolvingEntity)
            result = true
        }
        return result
    }

    fun findProblemSolvingByUsername(user: User?): List<ProblemSolving?>? {
        return problemSolvingRepository.findProblemSolvingByUsername(user)
    }

    fun findProblemSolvingById(problemSolvingEntity: ProblemSolving?): ProblemSolving? {
        return problemSolvingRepository.findProblemSolvingById(problemSolvingEntity?.cproblemSolving)
    }
}