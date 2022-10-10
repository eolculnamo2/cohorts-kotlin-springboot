package com.cohorts.allowance.services.impl

import com.cohorts.allowance.dao.ChildrenDao
import com.cohorts.allowance.entities.ChildEntity
import com.cohorts.allowance.jax.Child
import com.cohorts.allowance.mappers.toEntity
import com.cohorts.allowance.services.ChildrenService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ChildrenServiceImpl @Autowired constructor(private val childrenDao: ChildrenDao) : ChildrenService {
    override fun getAllChildren(userId: String): List<ChildEntity> {
       return childrenDao.findByUserId(userId);
    }

    override fun createNewChild(userId: String, child: Child) {
        val newChildEntity = child.toEntity(userId);
       childrenDao.insertChildrenForUser(userId, newChildEntity);
    }
}