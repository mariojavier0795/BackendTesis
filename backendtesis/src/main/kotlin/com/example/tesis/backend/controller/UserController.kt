package com.example.tesis.backend.controller


import com.example.tesis.backend.entity.User
import com.example.tesis.backend.entity.UserRoles
import com.example.tesis.backend.service.UserRolesService
import com.example.tesis.backend.service.UserService
import com.example.tesis.backend.structure.JsonStructure
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@CrossOrigin("*")
@RequestMapping("/user")
@RestController
class UserController(private val userService: UserService, private val userRolesService: UserRolesService) {

    @PostMapping("/saveUser")
    fun saveUser(@RequestBody jsonStructureRequest: JsonStructure): ResponseEntity<JsonStructure> {
        val userSaved = userService.saveUser(jsonStructureRequest.user)
        val userRoles = UserRoles(null, jsonStructureRequest.role, userSaved)
        val userRolesSaved = userRolesService.saveUserRole(userRoles)
        return ResponseEntity.ok(JsonStructure(userSaved, null, null, null, null, null,
            null, null, null, null, null, null, null,
            null, null, userRolesSaved))
    }

    @GetMapping("/logInUser")
    fun logInUser(@RequestParam parameters: Map<String, String>): ResponseEntity<List<User>> {
        val username = parameters["username"]
        val password = parameters["password"]
        return userService.logInUser(username, password)
    }


}
