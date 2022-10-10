package com.cohorts.allowance.resources

import com.cohorts.allowance.jax.NewUser
import com.cohorts.allowance.jax.User
import com.cohorts.allowance.services.RegisterService
import org.springframework.beans.factory.annotation.Autowired
import javax.ws.rs.BadRequestException
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/register")
class RegisterResource @Autowired constructor(
        private val registerService: RegisterService
) {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun register(newUser: NewUser): User {
        if (newUser == null) {
          throw BadRequestException("New User payload is required");
        }
        return registerService.register(newUser);
    }
}