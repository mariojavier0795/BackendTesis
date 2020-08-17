package com.example.tesis.backend.repository

import com.example.tesis.backend.entity.ProblemSolving
import com.example.tesis.backend.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ProblemSolvingRepository : JpaRepository<ProblemSolving, Long> {

    @Query("SELECT ps FROM ProblemSolving ps JOIN ps.serviceProblemFix spf JOIN spf.service s WHERE s.user = :puser")
    fun findProblemSolvingByUsername(@Param("puser") user: User?) : List<ProblemSolving?>?

    @Query("FROM ProblemSolving WHERE cproblemSolving = :pcproblemSolving")
    fun findProblemSolvingById(@Param("pcproblemSolving") cproblemSolving: Int?): ProblemSolving?
}