package com.example.tesis.backend.controller


import com.example.tesis.backend.entity.User
import com.example.tesis.backend.entity.UserRoles
import com.example.tesis.backend.security.SecurityConstants
import com.example.tesis.backend.service.UserRolesService
import com.example.tesis.backend.service.UserService
import com.example.tesis.backend.structure.JsonStructure
import com.example.tesis.backend.util.JWTUtil
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.nio.charset.StandardCharsets
import java.util.*

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
            null, null, userRolesSaved, null))
    }

    @PostMapping("/login")
    fun logInUser(@RequestBody user: User?): ResponseEntity<JsonStructure> {
        val user = userService.login(user)
        return ResponseEntity.ok(JsonStructure(user, null, null, null, null, null,
                null, null, null, null, null, null, null,
                null, null, null,JWTUtil().addAuthentication(user.username)))
    }


}
