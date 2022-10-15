package com.cohorts.allowance.utils

import io.jsonwebtoken.Claims
import javax.ws.rs.NotAuthorizedException

class AuthUtils {
    companion object {
        fun validateUserId(claims: Claims?, userId: String?) {
            if (claims?.id != userId) {
                throw NotAuthorizedException("User ID does not match");
            }
        }
    }
}