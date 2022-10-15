package com.cohorts.allowance.resources

import com.cohorts.allowance.constants.AuthConstants
import com.cohorts.allowance.entities.ChildEntity
import com.cohorts.allowance.jax.Child
import com.cohorts.allowance.services.ChildrenService
import com.cohorts.allowance.services.JwtService
import com.cohorts.allowance.utils.AuthUtils
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
        token.let(jwtService::decodeJWT).let{ AuthUtils.validateUserId(it, userId.toString())}
        childrenService.createNewChild(userId.toString(), newChild);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getChildrenForUser(@PathParam("userId") userId: UUID, @HeaderParam(AuthConstants.AUTH_HEADER) token: String): List<ChildEntity> {
        token.let(jwtService::decodeJWT).let{ AuthUtils.validateUserId(it, userId.toString())}
        return childrenService.getAllChildren(userId.toString());
    }

    @DELETE
    @Path("/{childId}")
    fun deleteChild(@PathParam("userId") userId: UUID, @PathParam("childId") childId: UUID, @HeaderParam(AuthConstants.AUTH_HEADER) token: String) {
        token.let(jwtService::decodeJWT).let{ AuthUtils.validateUserId(it, userId.toString())}
        childrenService.deleteChild(userId.toString(), childId.toString());
    }
}