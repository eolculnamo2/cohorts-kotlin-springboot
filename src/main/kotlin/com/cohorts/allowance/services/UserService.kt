package com.cohorts.allowance.services

import com.cohorts.allowance.jax.NewUser
import com.cohorts.allowance.jax.User

interface UserService {
    fun getAllUsers(): List<User>
    fun createUser(newUser: NewUser): User
}