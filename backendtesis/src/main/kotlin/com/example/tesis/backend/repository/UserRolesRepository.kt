package com.example.tesis.backend.repository

import com.example.tesis.backend.entity.Role
import com.example.tesis.backend.entity.User
import com.example.tesis.backend.entity.UserRoles
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface UserRolesRepository : JpaRepository<UserRoles, Long> {

    @Query("From UserRoles where role=:pRole and user=:pUser")
    fun validateRoleAndUser(@Param("pRole") role: Role?, @Param("pUser") user: User?): UserRoles?
}