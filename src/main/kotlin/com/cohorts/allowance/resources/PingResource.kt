package com.cohorts.allowance.resources

import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("/ping")
class PingResource {

    @GET
    fun ping(): String {
        return "Ping!"
    }
}