package com.example.tesis.backend.repository

import com.example.tesis.backend.entity.Service
import com.example.tesis.backend.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ServiceRepository : JpaRepository<Service, Long> {

    @Query("from Service where user=:puser")
    fun findServicebyUsername(@Param("puser") user: User?): List<Service>?

    @Query("from Service where cservice=:pcservice")
    fun findServicebyId(@Param("pcservice") cservice: Int?): Service?
}