package com.example.tesis.backend.repository

import com.example.tesis.backend.entity.TypeDocuments
import com.example.tesis.backend.entity.TypeDocumentsDetail
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface TypeDocumentsDetailRepository: JpaRepository<TypeDocumentsDetail, Long> {

    @Query("FROM TypeDocumentsDetail tdd WHERE tdd.typeDocuments = :ptypeDocuments")
    fun getTypeDocumentsDetail(@Param("ptypeDocuments") ptypeDocuments: TypeDocuments?): List<TypeDocumentsDetail?>?

}