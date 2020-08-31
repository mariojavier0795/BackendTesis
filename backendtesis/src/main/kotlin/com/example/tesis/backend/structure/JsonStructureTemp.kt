package com.example.tesis.backend.structure

import com.example.tesis.backend.entity.TypeDocumentsDetail

data class JsonStructureTemp(
        val imagen: String?,
        val listTypeDocumentsDetail: List<TypeDocumentsDetail>?
)