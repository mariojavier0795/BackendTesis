package com.example.tesis.backend.repository


import com.example.tesis.backend.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {

    @Query("FROM User where username = :pusername")
    fun findByUsername(@Param("pusername") username: String?): User?

    @Query("FROM User where cuser = :pcuser")
    fun findyByCUser(@Param("pcuser") cuser: Int?): User?
}