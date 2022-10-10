package com.cohorts.allowance.services

interface PasswordEncryptionService {
    fun encrypt(raw: String): String
    fun isValid(attempt: String, actual: String): Boolean
}