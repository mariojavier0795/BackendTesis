package com.example.tesis.backend.controller

import com.example.tesis.backend.repository.PersonRepository
import com.example.tesis.backend.entity.Persona
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@CrossOrigin("*")
@RequestMapping("/person")
@RestController
class PersonController(private val personRepository : PersonRepository) {
    @GetMapping("/searchPerson")
    fun getSearchPerson() : List<Persona> {
        return personRepository.findAll();
    }
}