package com.example.tesis.backend.controller


import com.example.tesis.backend.entity.User
import com.example.tesis.backend.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@CrossOrigin("*")
@RequestMapping("/user")
@RestController
class UserController(private val userRepository : UserRepository) {

    @PostMapping("/validateUser", produces= arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun getSearchUser(@RequestBody() bodyRequestUser : User) : ResponseEntity<Any> {
        val hashMap: HashMap<String, Any> = HashMap()
        return try {
            val listResponseUser = userRepository.findUser(bodyRequestUser.username, bodyRequestUser.password)
            hashMap["Array"] = listResponseUser
            hashMap["Status"] = "True"
            if (listResponseUser.isEmpty()) {
                hashMap["Message"] = "Usuario y/o contraseña están incorrectos"
                hashMap["Status"] = "False"
            }
            ResponseEntity(hashMap, HttpStatus.OK)
        } catch (e: Exception) {
            hashMap["Error message"] = e.message.toString()
            ResponseEntity(hashMap, HttpStatus.BAD_REQUEST)
        }
    }

}