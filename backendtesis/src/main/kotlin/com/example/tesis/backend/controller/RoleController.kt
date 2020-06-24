package com.example.tesis.backend.controller

import com.example.tesis.backend.entity.Role
import com.example.tesis.backend.repository.RoleRepository
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin("*")
@RequestMapping("/role")
@RestController
class RoleController(private val roleRepository: RoleRepository) {
    @GetMapping("/searchRole")
    fun getSearchUser() : List<Role> {
        return roleRepository.findAll();
    }
}