package com.example.tesis.backend.security

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource


@Configuration
@EnableWebSecurity
class SecurityConfig: WebSecurityConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()

        config.addAllowedOrigin("*")
        config.addAllowedHeader("*")
        config.addAllowedMethod("GET")
        config.addAllowedMethod("PUT")
        config.addAllowedMethod("POST")
        config.addAllowedMethod("DELETE")
        config.addAllowedMethod("PATCH")
        config.addAllowedMethod("OPTIONS")
        source.registerCorsConfiguration("/**", config)

        http.cors().and().csrf().disable()
                .addFilterAfter(JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter::class.java)
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/user/login").permitAll()
                .antMatchers(HttpMethod.POST, "/user/loadInformation").permitAll()
                .antMatchers(HttpMethod.POST, "/user/saveUser").permitAll()
                .antMatchers(HttpMethod.GET, "/role/getRole").permitAll()
                .antMatchers(HttpMethod.POST, "/ocr/test2").permitAll()
                .antMatchers(HttpMethod.GET, "/ocr/getTypeDocuments").permitAll()
                .antMatchers(HttpMethod.POST, "/ocr/getTypeDocumentsDetail").permitAll()
                .antMatchers(HttpMethod.POST, "/ocr/saveTypeDocumentsDetail").permitAll()
                .antMatchers(HttpMethod.POST, "/ocr/saveImage").permitAll()
                .antMatchers(HttpMethod.GET, "/ocr/getDocuments").permitAll()
                .antMatchers(HttpMethod.POST, "/ocr/getDocumentsID").permitAll()
                .antMatchers(HttpMethod.POST, "/ocr/reconocerOCR").permitAll()
                .antMatchers(HttpMethod.POST, "/ocr/drawOCR").permitAll()
                .anyRequest().authenticated()
    }
}