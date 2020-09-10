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

    fun deleteServicebyId(service: Service?): Boolean {
        var result = false
        if (service != null) {
            serviceRepository.delete(service)
            result = true
        }
        return result
    }

    fun findServicebyId(service: Service?): Service? {
        return serviceRepository.findServicebyId(service?.cservice)
    }

    fun saveOrUpdateService(service: Service?): Service? {
        var serviceResponse = Service()
        if (service !=null) {
            serviceResponse = serviceRepository.save(service)
        }
        return serviceResponse
    }

}