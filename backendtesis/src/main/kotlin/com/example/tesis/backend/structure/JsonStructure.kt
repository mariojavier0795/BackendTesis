package com.example.tesis.backend.structure

import com.example.tesis.backend.entity.*

data class JsonStructure (

        val user: User?,
        val role: Role?,
        val branchOffice: BranchOffice?,
        val commentary: Commentary?,
        val imagen: Imagen?,
        val problemSolving: ProblemSolving?,
        val reaction: Reaction?,
        val reactionService: ReactionService?,
        val reservation: Reservation?,
        val service: Service?,
        val serviceBranch: ServiceBranch?,
        val serviceProblemFix: ServiceProblemFix?,
        val servicesCategory: ServicesCategory?,
        val serviceTag: ServiceTag?,
        val tag: Tag?,
        val userRoles: UserRoles?

)