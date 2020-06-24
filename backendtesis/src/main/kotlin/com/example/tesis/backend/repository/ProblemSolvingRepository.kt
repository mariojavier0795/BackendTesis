package com.example.tesis.backend.repository

import com.example.tesis.backend.entity.ProblemSolving
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProblemSolvingRepository : JpaRepository<ProblemSolving, Long> {
}