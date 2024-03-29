package com.example.tesis.backend.repository

import com.example.tesis.backend.entity.Reservation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReservationRepository : JpaRepository<Reservation, Long> {
}