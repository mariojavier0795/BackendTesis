package com.example.tesis.backend.controller


import com.example.tesis.backend.entity.Role
import com.example.tesis.backend.entity.UserRoles
import com.example.tesis.backend.repository.UserRolesRepository
import com.example.tesis.backend.service.UserRolesService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/userRoles")
@RestController
class UserRolesController(private val userRolesService: UserRolesService) {

}