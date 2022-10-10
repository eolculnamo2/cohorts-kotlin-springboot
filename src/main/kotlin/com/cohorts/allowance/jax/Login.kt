package com.cohorts.allowance.jax

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class Login(
    @field:Email val email: String,
    @field:NotBlank val password: String
)