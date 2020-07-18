package com.example.tesis.backend.service

import com.example.tesis.backend.entity.User
import com.example.tesis.backend.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service()
class UserService(private val userRepository : UserRepository) {

    fun saveUser(user: User?): User {
        var userSaved = User()
        if(user != null) {
            userSaved = userRepository.save(user)
        }
        return userSaved
    }

    fun login(user: User?): User {
        val user = userRepository.findByUsername(user?.username)
        return user!!
    }

}