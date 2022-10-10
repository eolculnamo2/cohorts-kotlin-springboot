package com.cohorts.allowance.dao;


import com.cohorts.allowance.entities.ChildEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository;
import java.sql.ResultSet


@Repository
class ChildrenDao @Autowired constructor(private val jdbcTemplate: JdbcTemplate) {

    private fun mapChildEntity(resultSet: ResultSet): ChildEntity {
        return ChildEntity(
                uuid = checkNotNull(resultSet.getString("uuid")),
                userId = checkNotNull(resultSet.getString("user_id")),
                firstName = checkNotNull(resultSet.getString("first_name")),
                lastName = checkNotNull(resultSet.getString("last_name")),
                pendingPayout = resultSet.getInt("pending_payout"),
                lifetimePayout = resultSet.getInt("lifetime_payout")
        )
    }

    private val rowMapper: RowMapper<ChildEntity> = RowMapper<ChildEntity> { resultSet: ResultSet, _: Int -> mapChildEntity(resultSet) }

    fun insertChildrenForUser(userId: String, child: ChildEntity): ChildEntity {
        jdbcTemplate.execute("INSERT INTO children(uuid, user_id, first_name, last_name) VALUES" +
                "('${child.uuid}', '${child.userId}', '${child.firstName}', '${child.lastName}')");
        return child;
    }

    fun findByUserId(userId: String): List<ChildEntity> = jdbcTemplate.query("SELECT * FROM children WHERE user_id = '$userId'",rowMapper).toList();
}
