package com.example.tesis.backend.repository

import com.example.tesis.backend.entity.BranchOffice
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BranchOfficeRepository : JpaRepository<BranchOffice, Long> {
}