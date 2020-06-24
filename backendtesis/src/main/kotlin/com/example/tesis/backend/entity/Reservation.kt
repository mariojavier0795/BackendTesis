package com.example.tesis.backend.entity

import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "reserva")
data class Reservation (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "CRESERVA")
        var creservation : Int? = null,

        @Column(name = "FRESERVA")
        var freservation : Timestamp? = null,

        @Column(name = "NOMBRE_RESERVA")
        var reservationName : String? = null,

        @Column(name = "OBSERVACION_RESERVA")
        var observationReserve : String? = null,

        @Column(name = "HORA_RESERVA")
        var reservationHour : Int? = null,

        @Column(name = "MINUTO_RESERVA")
        var reservationMinute : Int? = null,

        @Column(name = "FCONFIRMACIONSERVICIO")
        var fServiceConfirmation : Timestamp? = null,

        @Column(name = "FACUERDOSERVICIO")
        var fServiceAgreement : Timestamp? = null,

        @Column(name = "LATITUD_DOMICILIO")
        var latitudeHomeService : Float? = null,

        @Column(name = "LONGITUD_DOMICILIO")
        var longitudeHomeService  : Float? = null,

        @Column(name = "FINICIO_RESERVA_SERVICIO")
        var startDateBooking : Timestamp? = null,

        @Column(name = "FFIN_RESERVA_SERVICIO")
        var endDateBooking : Timestamp? = null,

        @Column(name = "DIRECCION_RESERVA")
        var reservationAddress : String? = null,

        @Column(name = "ESTATUSRESERVA")
        var reservationStatus : String? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CSERVICIO", referencedColumnName = "CSERVICIO")
        var service : Service? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CSERVICIOSUCURSAL", referencedColumnName = "CSERVICIOSUCURSAL")
        var serviceBranch : ServiceBranch? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CUSUARIO", referencedColumnName = "CUSUARIO")
        var user : User? = null
)