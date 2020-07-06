package com.example.tesis.backend.controller


import com.example.tesis.backend.entity.Role
import com.example.tesis.backend.entity.User
import com.example.tesis.backend.entity.UserRoles
import com.example.tesis.backend.repository.UserRepository
import com.example.tesis.backend.repository.UserRolesRepository
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ObjectNode
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@CrossOrigin("*")
@RequestMapping("/user")
@RestController
class UserController(private val userRepository : UserRepository) {

    val jsonMap: HashMap<String, Any> = HashMap()

    @GetMapping("/loginUser")
    fun loginUser(@RequestParam() parameters: Map<String, String>) : ResponseEntity<Any> {
        return try {
            val listResponseUser = userRepository.findUser(parameters.get("username"), parameters.get("password"))
            jsonMap["Array"] = listResponseUser
            jsonMap["Status"] = "True"
            if (listResponseUser.isEmpty()) {
                jsonMap["Message"] = "Usuario y/o contraseña están incorrectos"
                jsonMap["Status"] = "False"
            }
            ResponseEntity(jsonMap, HttpStatus.OK)
        } catch (e: Exception) {
            jsonMap["Error message"] = e.message.toString()
            ResponseEntity(jsonMap, HttpStatus.BAD_REQUEST)
        }
    }

    @PostMapping("/saveUser")
    fun saveUser(@RequestBody() user: User): User {
        return userRepository.save(user)
    }

}