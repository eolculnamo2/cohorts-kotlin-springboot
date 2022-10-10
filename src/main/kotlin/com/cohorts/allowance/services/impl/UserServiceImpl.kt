package com.cohorts.allowance.services.impl

import com.cohorts.allowance.dao.UserDao
import com.cohorts.allowance.entities.UserEntity
import com.cohorts.allowance.jax.NewUser
import com.cohorts.allowance.jax.User
import com.cohorts.allowance.mappers.toUser
import com.cohorts.allowance.services.PasswordEncryptionService
import com.cohorts.allowance.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl @Autowired constructor(
        private val userDao: UserDao,
        private val passwordEncryptionService: PasswordEncryptionService
    ) : UserService {

    override fun getAllUsers(): List<User> {
        val userEntities = userDao.getAllUsers()
        // lambda generally uses curly braces like this:
        // userEntities.map { userEntity -> userEntity.toUser() }
        return userEntities.map(UserEntity::toUser)
    }

    override fun createUser(newUser: NewUser): User {
        val entity = UserEntity(
            uuid = UUID.randomUUID().toString(),
            email = newUser.email,
            password = newUser.password.let(passwordEncryptionService::encrypt),
            firstName = newUser.firstName,
            lastName = newUser.lastName,
            enabled = true,
        )
        userDao.createUser(entity)
        return entity.toUser()
    }
}