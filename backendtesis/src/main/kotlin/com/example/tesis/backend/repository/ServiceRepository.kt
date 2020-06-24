package com.example.tesis.backend.repository

import com.example.tesis.backend.entity.Service
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ServiceRepository : JpaRepository<Service, Long> {
}