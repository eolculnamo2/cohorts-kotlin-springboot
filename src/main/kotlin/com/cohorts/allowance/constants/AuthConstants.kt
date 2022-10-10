package com.cohorts.allowance.constants

class AuthConstants {
    companion object {
        // in real life we'd keep this more secret
        const val JWT_TOKEN = "askdfoinogn294ugh943h92nf1nf18fj0ndjansviasndgi";
        const val TOKEN_TIMEOUT = 60 * 60 * 1000; // 1 hr
        const val AUTH_HEADER = "Authorization";
        const val USER_ID = "userId";
    }
}