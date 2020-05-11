package com.example.tesis.backend

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@CrossOrigin("*")
@RequestMapping("/person")
@RestController
class PersonController(private val personRepository : PersonRepository) {
    @GetMapping("/searchPerson")
    fun getSearchPerson() : List<Person> {
        return personRepository.findAll();
    }
}