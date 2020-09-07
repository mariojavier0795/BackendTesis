package com.example.tesis.backend.service

import com.example.tesis.backend.entity.User
import com.example.tesis.backend.repository.UserRepository
import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.stereotype.Service

@Service()
class UserService(private val userRepository : UserRepository) {

    fun saveUser(user: User?): User? {
        user?.password = BCrypt.hashpw(user?.password, BCrypt.gensalt(12))
        return if(user != null) {
            userRepository.save(user)
        }else {
            null
        }
    }

    fun login(user: User?): User? {
        val userResponse = userRepository.findByUsername(user?.username)
        return if (userResponse != null) {
            val matched = BCrypt.checkpw(user?.password, userResponse.password)
            if (matched) userResponse else null
        }else {
            null
        }
    }

    fun loadInformationUserByCuser(user: User?): User? {
        return userRepository.findyByCUser(user?.cuser)
    }

}