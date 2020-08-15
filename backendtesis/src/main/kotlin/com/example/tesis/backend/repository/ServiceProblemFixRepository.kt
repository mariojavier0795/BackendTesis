package com.example.tesis.backend.repository

import com.example.tesis.backend.entity.ServiceProblemFix
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ServiceProblemFixRepository : JpaRepository<ServiceProblemFix, Long> {

    @Query("FROM ServiceProblemFix WHERE cserviceProblemFix = :pcserviceProblemFix")
    fun findServiceProblemFixesById(@Param("pcserviceProblemFix") pcserviceProblemFix: Int?): ServiceProblemFix?
}