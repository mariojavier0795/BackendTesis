package com.example.tesis.backend.controller

import com.example.tesis.backend.repository.PersonRepository
import com.example.tesis.backend.entity.Persona
import org.springframework.web.bind.annotation.*


@CrossOrigin("*")
@RequestMapping("/person")
@RestController
class PersonController(private val personRepository : PersonRepository) {

    @GetMapping("/searchPerson")
    fun getSearchPerson() : List<Persona> {
        return personRepository.findAll()
    }

    @PostMapping("/searchNamesPerson")
    fun searchNamesPerson(@RequestBody persona: Persona) : List<Persona> {
        return personRepository.findByNameOrLastname(persona.nombres, persona.apellidos)
    }
}