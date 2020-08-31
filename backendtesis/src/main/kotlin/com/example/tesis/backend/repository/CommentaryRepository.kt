package com.example.tesis.backend.repository

import com.example.tesis.backend.entity.Commentary
import com.example.tesis.backend.entity.Service
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface CommentaryRepository : JpaRepository<Commentary, Long> {

    @Query("FROM Commentary WHERE service = :pservice")
    fun findCommentaryByService(@Param("pservice") service: Service?): List<Commentary?>?
}