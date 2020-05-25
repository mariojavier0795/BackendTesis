package com.example.tesis.backend.controller


import com.example.tesis.backend.entity.Usuario
import com.example.tesis.backend.repository.UserRepository
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@CrossOrigin("*")
@RequestMapping("/user")
@RestController
class UserController(private val userRepository : UserRepository) {
    @GetMapping("/searchUser")
    fun getSearchUser() : List<Usuario> {
        return userRepository.findAll();
    }
}