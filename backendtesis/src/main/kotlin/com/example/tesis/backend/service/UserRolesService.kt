package com.example.tesis.backend.service

import com.example.tesis.backend.entity.UserRoles
import com.example.tesis.backend.repository.UserRolesRepository
import org.springframework.stereotype.Service

@Service
class UserRolesService (private val userRolesRepository: UserRolesRepository) {

    fun saveUserRole(userRoles: UserRoles?): UserRoles {
        var userRolesSaved = UserRoles()
        if(userRoles != null) {
            userRolesSaved = userRolesRepository.save(userRoles)
        }
        return userRolesSaved
    }


}