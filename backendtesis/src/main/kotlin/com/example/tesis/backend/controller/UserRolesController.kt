package com.example.tesis.backend.controller


import com.example.tesis.backend.entity.UserRoles
import com.example.tesis.backend.repository.UserRolesRepository
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin("*")
@RequestMapping("/userroles")
@RestController
class UserRolesController(private val userRolesRepository: UserRolesRepository) {
    @GetMapping("/searchUserRoles")
    fun getSearchUser() : List<UserRoles> {
        return userRolesRepository.findAll();
    }
}