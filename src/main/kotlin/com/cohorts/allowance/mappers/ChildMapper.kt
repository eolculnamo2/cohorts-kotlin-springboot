package com.cohorts.allowance.mappers

import com.cohorts.allowance.entities.ChildEntity
import com.cohorts.allowance.jax.Child
import java.util.UUID


fun Child.toEntity(userId: String): ChildEntity {
    return ChildEntity(
            uuid = UUID.randomUUID().toString(),
            userId = userId,
            firstName = firstName,
            lastName = lastName,
            pendingPayout = 0,
            lifetimePayout = 0,
    )
}