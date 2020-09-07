package com.example.tesis.backend.controller

import com.example.tesis.backend.entity.Service
import com.example.tesis.backend.entity.User
import com.example.tesis.backend.service.CommentaryService
import com.example.tesis.backend.service.ImageService
import com.example.tesis.backend.service.ReactionServiceService
import com.example.tesis.backend.service.ServiceService
import com.example.tesis.backend.structure.JsonStructure
import org.json.simple.JSONArray
import org.json.simple.JSONObject
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin("*")
@RequestMapping("/service")
@RestController
class ServiceController(private val serviceService: ServiceService,
                        private val commentaryService: CommentaryService,
                        private val reactionServiceService: ReactionServiceService,
                        private val imageService: ImageService) {

    @PostMapping("getServiceByUser")
    fun getService(@RequestBody jsonRequest: JsonStructure?): ResponseEntity<JSONObject> {
        val jsonResponse = JSONObject()
        val arrayStructureJsonResponse = JSONArray()
        val listServices = serviceService.findServicebyUsername(jsonRequest?.user)
        if(!listServices.isNullOrEmpty()) {
            listServices.forEach {
                val listImages = imageService.findImagebyService(it)
                val structureJsonResponse = JSONObject()
                structureJsonResponse["cservice"] = it.cservice
                structureJsonResponse["serviceName"] = it.serviceName
                structureJsonResponse["unitPrice"] = it.unitPrice
                structureJsonResponse["description"] = it.description
                structureJsonResponse["serviceAlias"] = it.serviceAlias
                structureJsonResponse["filetype"] = listImages?.get(0)?.filetype
                structureJsonResponse["image"] = listImages?.get(0)?.image
                arrayStructureJsonResponse.add(structureJsonResponse)
            }
        }else{
            arrayStructureJsonResponse.add(null)
        }
        jsonResponse["ListServices"] = arrayStructureJsonResponse
        return ResponseEntity.ok(jsonResponse)
    }

    @PostMapping("deleteServicebyId")
    fun deleteServicebyId(@RequestBody jsonRequest: JsonStructure?): ResponseEntity<JSONObject> {
        val jsonResponse = JSONObject()
        val result = serviceService.deleteServicebyId(jsonRequest?.service)
        jsonResponse["Result"] = result
        return ResponseEntity.ok(jsonResponse)
    }

    @PostMapping("getServiceById")
    fun getServiceById(@RequestBody jsonRequest: JsonStructure?): ResponseEntity<JSONObject> {
        val jsonResponse = JSONObject()
        val result = serviceService.findServicebyId(jsonRequest?.service)
        val listImage = imageService.findImagebyService(jsonRequest?.service)
        jsonResponse["ListImage"] = listImage
        jsonResponse["Service"] = result
        return ResponseEntity.ok(jsonResponse)
    }

    @PostMapping("saveOrUpdateService")
    fun saveOrUpdateService(@RequestBody jsonRequest: JsonStructure?): ResponseEntity<JSONObject> {
        val jsonResponse = JSONObject()
        val flagUpdate = serviceService.updateService(jsonRequest?.service)
        jsonResponse["Result"] = flagUpdate
        return ResponseEntity.ok(jsonResponse)
    }

    @PostMapping("getServiceDetailById")
    fun getServiceDetailById(@RequestBody jsonRequest: JsonStructure?): ResponseEntity<JSONObject> {
        val jsonResponse = JSONObject()
        val serviceResponse = serviceService.findServicebyId(jsonRequest?.service)
        val listCommentaryResponse = commentaryService.findCommentaryByService(jsonRequest?.service)
        val listReactionServiceResponse = reactionServiceService.findReactionServiceByService(jsonRequest?.service)
        jsonResponse["Service"] = serviceResponse
        jsonResponse["ListCommentaryResponse"] = listCommentaryResponse
        jsonResponse["ListReactionServiceResponse"] = listReactionServiceResponse
        return ResponseEntity.ok(jsonResponse)
    }
}