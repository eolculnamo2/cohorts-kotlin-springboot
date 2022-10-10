package com.cohorts.allowance.jax;

data class UserResponse (
    val uuid: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val enabled: Boolean,
    val jwt: String?
)
