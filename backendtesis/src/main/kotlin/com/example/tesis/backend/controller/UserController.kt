package com.example.tesis.backend.controller


import com.example.tesis.backend.entity.User
import com.example.tesis.backend.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@CrossOrigin("*")
@RequestMapping("/user")
@RestController
class UserController(private val userService: UserService) {

    @PostMapping("/saveUser")
    fun saveUser(@RequestBody user: User): ResponseEntity<User> = userService.saveUser(user)

    @GetMapping("/logInUser")
    fun logInUser(@RequestParam parameters: Map<String, String>): ResponseEntity<List<User>> {
        val username = parameters["username"]
        val password = parameters["password"]
        return userService.logInUser(username, password)
    }

}