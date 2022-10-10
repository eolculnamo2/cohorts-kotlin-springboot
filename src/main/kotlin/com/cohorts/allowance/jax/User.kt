package com.cohorts.allowance.jax

data class User(
    val uuid: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val enabled: Boolean,
)