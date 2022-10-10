package com.cohorts.allowance.resources

import com.cohorts.allowance.constants.AuthConstants
import com.cohorts.allowance.entities.ChildEntity
import com.cohorts.allowance.jax.Child
import com.cohorts.allowance.services.ChildrenService
import com.cohorts.allowance.services.JwtService
import org.springframework.beans.factory.annotation.Autowired
import java.util.*
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/users/{userId}/children")
class ChildrenResource @Autowired constructor(
        private val childrenService: ChildrenService,
        private val jwtService: JwtService
        ) {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun createNewChild(@PathParam("userId") userId: UUID, newChild: Child, @HeaderParam(AuthConstants.AUTH_HEADER) token: String) {
        val claims = jwtService.decodeJWT(token);
        if (claims?.id != userId.toString()) {
            throw NotAuthorizedException("User ID does not match");
        }
        childrenService.createNewChild(userId.toString(), newChild);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getChildrenForUser(@PathParam("userId") userId: UUID, @HeaderParam(AuthConstants.AUTH_HEADER) token: String): List<ChildEntity> {
        val claims = jwtService.decodeJWT(token);
        if (claims?.id != userId.toString()) {
            throw NotAuthorizedException("User ID does not match");
        }
        return childrenService.getAllChildren(userId.toString());
    }
}