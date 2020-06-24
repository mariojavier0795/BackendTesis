package com.example.tesis.backend.repository

import com.example.tesis.backend.entity.UserRoles
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRolesRepository : JpaRepository<UserRoles, Long> {
}