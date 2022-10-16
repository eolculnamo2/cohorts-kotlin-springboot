package com.cohorts.allowance.resources

import com.cohorts.allowance.jax.Login
import com.cohorts.allowance.jax.UserResponse
import com.cohorts.allowance.services.LoginService
import org.springframework.beans.factory.annotation.Autowired
import javax.validation.Valid
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/login")
class LoginResource @Autowired constructor(private val loginService: LoginService) {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun login(@Valid login: Login): UserResponse = loginService.authenticate(login.email, login.password)

    @DELETE
    fun logout() {
        println("Logging out...")
    }
}