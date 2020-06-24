package com.example.tesis.backend.repository

import com.example.tesis.backend.entity.ServiceTag
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ServiceTagRepository : JpaRepository<ServiceTag, Long> {
}