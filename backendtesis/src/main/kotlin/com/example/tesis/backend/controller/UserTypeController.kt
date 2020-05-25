package com.example.tesis.backend.controller

import com.example.tesis.backend.entity.TipoUsuario
import com.example.tesis.backend.entity.Usuario
import com.example.tesis.backend.repository.UserTypeRepository
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin("*")
@RequestMapping("/userType")
@RestController
class UserTypeController (private val userTypeRepository : UserTypeRepository) {
    @GetMapping("/searchUserType")
    fun getSearchUserType() : List<TipoUsuario> {
        return userTypeRepository.findAll();
    }
}