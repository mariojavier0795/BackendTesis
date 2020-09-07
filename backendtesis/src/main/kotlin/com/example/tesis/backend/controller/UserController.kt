package com.example.tesis.backend.controller


import com.example.tesis.backend.entity.Role
import com.example.tesis.backend.entity.User
import com.example.tesis.backend.entity.UserRoles
import com.example.tesis.backend.service.UserRolesService
import com.example.tesis.backend.service.UserService
import com.example.tesis.backend.structure.JsonStructure
import com.example.tesis.backend.util.JWTUtil
import org.json.simple.JSONObject
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin("*")
@RequestMapping("/user")
@RestController
class UserController(private val userService: UserService, private val userRolesService: UserRolesService) {

    @PostMapping("/saveUser")
    fun saveUser(@RequestBody jsonStructureRequest: JsonStructure): ResponseEntity<JSONObject> {
        val jsonResponse = JSONObject()
        var status = false
        val userSaved = userService.saveUser(jsonStructureRequest.user)
        if(userSaved != null) {
            val userRoles = UserRoles(null, jsonStructureRequest.role, userSaved)
            val userRolesServiceSaved = userRolesService.saveUserRole(userRoles)
            status = true
        }else{
            jsonResponse.put("Mensaje", "Error en el Ingreo del usuario: ${jsonStructureRequest.user?.username}")
        }
        jsonResponse.put("Status", status)
        return ResponseEntity.ok(jsonResponse)
    }

    @PostMapping("/login")
    fun logInUser(@RequestBody jsonRequest: JsonStructure): ResponseEntity<JSONObject> {
        val jsonResponse = JSONObject()
        var status = false
        val userResponse = userService.login(jsonRequest.user)
        if(userResponse != null) {
            val userRolesResponse = userRolesService.validateRoleAndUser(jsonRequest.role, userResponse)
            if(userRolesResponse != null) {
                val tokenResponse = JWTUtil().addAuthentication(userResponse.username)
                status = true
                jsonResponse.put("Cuser", userResponse.cuser)
                jsonResponse.put("Token", tokenResponse)
            }else{
                jsonResponse.put("Mensaje", "El Rol no existe para este usuario: ${userResponse.username}")
            }
        }else{
            jsonResponse.put("Mensaje", "Usuari@ y Contraseñ@ Incorrectos para el Usuario ${jsonRequest.user?.username}")
        }
        jsonResponse.put("Status", status)
        return ResponseEntity.ok(jsonResponse)
    }

    @PostMapping("/loadInformation")
    fun loadInformation(@RequestBody jsonRequest: JsonStructure): ResponseEntity<JSONObject> {
        val jsonResponse = JSONObject()
        val userResponse = userService.loadInformationUserByCuser(jsonRequest.user)
        jsonResponse.put("FileType", userResponse?.filetype)
        jsonResponse.put("ImageUser", userResponse?.userImage)
        jsonResponse.put("Username", userResponse?.names + " "+ userResponse?.lastnames)
        return ResponseEntity.ok(jsonResponse)
    }
}
