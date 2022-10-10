package com.cohorts.allowance.services.impl

import com.cohorts.allowance.dao.UserDao
import com.cohorts.allowance.jax.User
import com.cohorts.allowance.jax.UserResponse
import com.cohorts.allowance.mappers.toUser
import com.cohorts.allowance.mappers.toUserResponse
import com.cohorts.allowance.services.JwtService
import com.cohorts.allowance.services.LoginService
import com.cohorts.allowance.services.PasswordEncryptionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.ws.rs.NotAuthorizedException
import javax.ws.rs.NotFoundException

@Service
class LoginServiceImpl @Autowired constructor(
        private val jwtService: JwtService,
        private val passwordEncryptionService: PasswordEncryptionService,
        private val userDao: UserDao
    ) : LoginService {

    override fun authenticate(email: String, password: String): UserResponse {
        val user = userDao.findByEmail(email) ?: throw NotFoundException("Unable to find user by email")
        if (!passwordEncryptionService.isValid(password, user.password)) {
            throw NotAuthorizedException("Invalid login")
        }
        val jwt = jwtService.createJWT(user.uuid, "app", "token");
        return user.toUserResponse(jwt)
    }

}