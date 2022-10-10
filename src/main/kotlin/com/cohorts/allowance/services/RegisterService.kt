package com.cohorts.allowance.services

import com.cohorts.allowance.jax.NewUser
import com.cohorts.allowance.jax.User

interface RegisterService {
    fun register(newUser: NewUser): User
}