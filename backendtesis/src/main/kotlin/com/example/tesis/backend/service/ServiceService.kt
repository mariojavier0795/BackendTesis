package com.example.tesis.backend.service

import com.example.tesis.backend.entity.Service
import com.example.tesis.backend.entity.User
import com.example.tesis.backend.repository.ServiceRepository

@org.springframework.stereotype.Service()
class ServiceService(private val serviceRepository: ServiceRepository) {
    fun findServicebyUsername(user: User?): List<Service>? {
        val serviceResponse = serviceRepository.findServicebyUsername(user)
        return if (user != null) serviceResponse else null
    }

    fun deleteServicebyId(service: Service?) {
        if (service != null) {
            serviceRepository.delete(service)
        }
    }

    fun findServicebyId(service: Service?): Service? {
        return serviceRepository.findServicebyId(service?.cservice)
    }

    fun updateService(service: Service?): Boolean {
        var flagUpdate = false
        if(service != null) {
            serviceRepository.save(service)
            flagUpdate = true
        }
        return flagUpdate
    }
}