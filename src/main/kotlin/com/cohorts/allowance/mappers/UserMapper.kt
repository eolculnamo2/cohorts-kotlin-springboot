package com.cohorts.allowance.mappers

import com.cohorts.allowance.entities.UserEntity
import com.cohorts.allowance.jax.NewUser
import com.cohorts.allowance.jax.User
import com.cohorts.allowance.jax.UserResponse
import java.util.UUID

// no great mapper options for kotlin?
// https://stackoverflow.com/questions/39199426/better-way-to-map-kotlin-data-objects-to-data-objects

fun UserEntity.toUser(): User {
    return User(
        uuid = uuid,
        email = email,
        firstName = firstName,
        lastName =  lastName,
        enabled = enabled,
    )
}

fun UserEntity.toUserResponse(jwt: String?): UserResponse {
    return UserResponse(
            uuid = uuid,
            email = email,
            firstName = firstName,
            lastName =  lastName,
            enabled = enabled,
            jwt = jwt
    )
}

fun NewUser.toEntity(encryptedPassword: String): UserEntity {
    return UserEntity(
            uuid = UUID.randomUUID().toString(),
            email = email,
            password = encryptedPassword,
            firstName = firstName,
            lastName = lastName,
            enabled = true,
    )
}