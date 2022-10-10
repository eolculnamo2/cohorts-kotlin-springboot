package com.cohorts.allowance.services.impl

import com.cohorts.allowance.dao.UserDao
import com.cohorts.allowance.entities.UserEntity
import com.cohorts.allowance.jax.NewUser
import com.cohorts.allowance.jax.User
import com.cohorts.allowance.mappers.toEntity
import com.cohorts.allowance.mappers.toUser
import com.cohorts.allowance.services.PasswordEncryptionService
import com.cohorts.allowance.services.RegisterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RegisterServiceImpl @Autowired constructor(
        private val passwordEncryptionService: PasswordEncryptionService,
        private val userDao: UserDao
) : RegisterService {
    override fun register(newUser: NewUser): User {
        return newUser.password
                .let(passwordEncryptionService::encrypt)
                .let(newUser::toEntity)
                .let(userDao::createUser)
                .let(UserEntity::toUser);
    }
}
