package com.example.tesis.backend.repository

import com.example.tesis.backend.entity.ServiceProblemFix
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ServiceProblemFixRepository : JpaRepository<ServiceProblemFix, Long> {
}