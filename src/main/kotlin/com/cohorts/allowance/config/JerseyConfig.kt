package com.cohorts.allowance.config

import com.cohorts.allowance.resources.*
import org.glassfish.jersey.server.ResourceConfig
import org.springframework.context.annotation.Configuration


@Configuration
class JerseyConfig : ResourceConfig() {
    init {
        register(PingResource::class.java)
        register(UsersResource::class.java)
        register(LoginResource::class.java)
        register(RegisterResource::class.java)
        register(ChildrenResource::class.java)
    }
}
