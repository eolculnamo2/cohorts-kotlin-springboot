package com.cohorts.allowance.entities

data class UserEntity(
    val uuid: String,
    val email: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val enabled: Boolean,
)