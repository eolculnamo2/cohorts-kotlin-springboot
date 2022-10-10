package com.cohorts.allowance.services

import com.cohorts.allowance.jax.User
import com.cohorts.allowance.jax.UserResponse

interface LoginService {
    fun authenticate(email: String, password: String): UserResponse
}