package com.example.tesis.backend.repository

import com.example.tesis.backend.entity.TypeDocuments
import org.springframework.data.jpa.repository.JpaRepository

interface TypeDocumentsRepository: JpaRepository<TypeDocuments, Long> {

}