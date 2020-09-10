package com.example.tesis.backend.service

import com.example.tesis.backend.entity.Imagen
import com.example.tesis.backend.repository.ImagenRepository
import org.springframework.stereotype.Service

@Service
class ImageService(private val imagenRepository: ImagenRepository) {

    fun findImagebyService(service: com.example.tesis.backend.entity.Service?): List<Imagen?>? {
        return imagenRepository.findImagebyService(service)
    }

    fun saveOrUpdateImage(imagen: Imagen?): Imagen? {
        return imagenRepository.save(imagen!!)
    }
}