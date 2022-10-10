package com.cohorts.allowance.services

import com.cohorts.allowance.entities.ChildEntity
import com.cohorts.allowance.jax.Child

interface ChildrenService {
    fun getAllChildren(userId: String): List<ChildEntity>
    fun createNewChild(userId: String, child: Child)
}