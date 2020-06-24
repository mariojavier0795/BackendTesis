package com.example.tesis.backend.repository

import com.example.tesis.backend.entity.ServiceBranch
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ServiceBranchRepository : JpaRepository<ServiceBranch, Long> {
}