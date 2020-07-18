package com.example.tesis.backend.util

import com.example.tesis.backend.security.SecurityConstants
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import java.nio.charset.StandardCharsets
import java.util.*
import javax.servlet.http.HttpServletRequest

class JWTUtil {

    fun addAuthentication(username: String?): String {
        val token = Jwts.builder().setSubject(username).setIssuedAt(Date(System.currentTimeMillis()))
                .setExpiration(Date(System.currentTimeMillis() + SecurityConstants().EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SecurityConstants().SECRET)
                .compact()
        return SecurityConstants().TOKEN_PREFIX + token
    }

    fun getAuthentication(req: HttpServletRequest): Authentication? {
        val token = req.getHeader(SecurityConstants().HEADER_STRING)
        if (token != null) {
            val user = Jwts.parser()
                    .setSigningKey(SecurityConstants().SECRET)
                    .parseClaimsJws(token.trim().replace(SecurityConstants().TOKEN_PREFIX, ""))
                    .body
                    .subject
            return if (user != null) {
                UsernamePasswordAuthenticationToken(user, null, emptyList())
            }else{
                null
            }
        }
        return null
    }

}