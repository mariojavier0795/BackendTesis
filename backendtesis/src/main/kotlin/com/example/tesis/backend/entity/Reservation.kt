package com.example.tesis.backend.entity

import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "reserva")
data class Reservation (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "CRESERVA")
        val creservation : Int? = null,

        @Column(name = "FRESERVA")
        val freservation : Timestamp? = null,

        @Column(name = "NOMBRE_RESERVA")
        val reservationName : String? = null,

        @Column(name = "OBSERVACION_RESERVA")
        val observationReserve : String? = null,

        @Column(name = "HORA_RESERVA")
        val reservationHour : Int? = null,

        @Column(name = "MINUTO_RESERVA")
        val reservationMinute : Int? = null,

        @Column(name = "FCONFIRMACIONSERVICIO")
        val fServiceConfirmation : Timestamp? = null,

        @Column(name = "FACUERDOSERVICIO")
        val fServiceAgreement : Timestamp? = null,

        @Column(name = "LATITUD_DOMICILIO")
        val latitudeHomeService : Float? = null,

        @Column(name = "LONGITUD_DOMICILIO")
        val longitudeHomeService  : Float? = null,

        @Column(name = "FINICIO_RESERVA_SERVICIO")
        val startDateBooking : Timestamp? = null,

        @Column(name = "FFIN_RESERVA_SERVICIO")
        val endDateBooking : Timestamp? = null,

        @Column(name = "DIRECCION_RESERVA")
        val reservationAddress : String? = null,

        @Column(name = "ESTATUSRESERVA")
        val reservationStatus : String? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CSERVICIO", referencedColumnName = "CSERVICIO")
        val service : Service? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CSERVICIOSUCURSAL", referencedColumnName = "CSERVICIOSUCURSAL")
        val serviceBranch : ServiceBranch? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CUSUARIO", referencedColumnName = "CUSUARIO")
        val user : User? = null
)