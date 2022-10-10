package com.cohorts.allowance.services

import io.jsonwebtoken.Claims


interface JwtService {
    fun createJWT(id: String?, issuer: String?, subject: String?): String?
    fun decodeJWT(jwt: String?): Claims?
}
