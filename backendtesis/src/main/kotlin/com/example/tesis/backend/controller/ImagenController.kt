package com.example.tesis.backend.controller

import com.example.tesis.backend.service.ImageService
import com.example.tesis.backend.structure.JsonStructure
import org.json.simple.JSONObject
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin("*")
@RequestMapping("/imagen")
@RestController
class ImagenController(private val imageService: ImageService) {

    @PostMapping("findImageByService")
    fun findImageByService(@RequestBody jsonStructureRequest: JsonStructure?): ResponseEntity<JSONObject> {
        val jsonResponse = JSONObject()
        val listImage = imageService.findImagebyService(jsonStructureRequest?.service)
        jsonResponse["ListImage"] = listImage
        return ResponseEntity.ok(jsonResponse)
    }
}