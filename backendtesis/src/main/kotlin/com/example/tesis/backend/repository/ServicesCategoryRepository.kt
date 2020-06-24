package com.example.tesis.backend.repository

import com.example.tesis.backend.entity.ServicesCategory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ServicesCategoryRepository : JpaRepository<ServicesCategory, Long> {
}