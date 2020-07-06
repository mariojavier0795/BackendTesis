package com.example.tesis.backend.controller


import com.example.tesis.backend.entity.Role
import com.example.tesis.backend.entity.UserRoles
import com.example.tesis.backend.repository.UserRolesRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin("*")
@RequestMapping("/userRoles")
@RestController
class UserRolesController(private val userRolesRepository: UserRolesRepository) {

    @PostMapping("/saveUserRoles")
    fun saveUserRole(@RequestBody() userRoles: UserRoles): UserRoles {
        return userRolesRepository.save(userRoles);
    }
}