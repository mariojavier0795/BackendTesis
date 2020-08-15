package com.example.tesis.backend.service

import com.example.tesis.backend.entity.ServiceProblemFix
import com.example.tesis.backend.entity.User
import com.example.tesis.backend.repository.ServiceProblemFixRepository
import com.example.tesis.backend.repository.ServiceRepository
import org.springframework.stereotype.Service

@Service()
class ServiceProblemFixService(
        private val serviceProblemFixRepository: ServiceProblemFixRepository) {

    fun insertServiceProblemFixService(serviceProblemFixEntity: ServiceProblemFix?): Boolean {
        var result = false
        if(serviceProblemFixEntity != null){
            serviceProblemFixRepository.save(serviceProblemFixEntity)
            result = true
        }
        return result
    }

    fun deleteServiceProblemFixService(serviceProblemFixEntity: ServiceProblemFix?): Boolean {
        var result = false
        if(serviceProblemFixEntity != null){
            serviceProblemFixRepository.delete(serviceProblemFixEntity)
            result = true
        }
        return result
    }

    fun findServiceProblemFixServicebyId(serviceProblemFixEntity: ServiceProblemFix?): ServiceProblemFix? {
        return serviceProblemFixRepository.findServiceProblemFixesById(serviceProblemFixEntity?.cserviceProblemFix)
    }

    fun findServiceProblemFixByUser(user: User?): List<ServiceProblemFix?>? {
        return serviceProblemFixRepository.findServiceProblemFixByUsername(user)
    }
}