package com.example.tesis.backend.controller

import com.example.tesis.backend.repository.ReservationRepository
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/reservation")
@RestController
class ReservationController(private val reservationRepository: ReservationRepository) {

}