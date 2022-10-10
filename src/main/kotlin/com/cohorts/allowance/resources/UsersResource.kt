package com.cohorts.allowance.resources

import com.cohorts.allowance.jax.NewUser
import com.cohorts.allowance.jax.User
import com.cohorts.allowance.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import javax.validation.Valid
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/users")
class UsersResource @Autowired constructor(private val userService: UserService) {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getAllUsers(): List<User> {
        return userService.getAllUsers()
    }

    // TODO @Valid throwing 404 instead of 400 for some reason
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun createNewUser(@Valid newUser: NewUser): User {
        return userService.createUser(newUser)
    }
}