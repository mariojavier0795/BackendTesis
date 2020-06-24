package com.example.tesis.backend.repository

import com.example.tesis.backend.entity.Commentary
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentaryRepository : JpaRepository<Commentary, Long> {
}