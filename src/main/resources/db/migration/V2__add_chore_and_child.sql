CREATE TABLE children (
    uuid VARCHAR(255) PRIMARY KEY,
    user_id VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    pending_payout INT DEFAULT 0, -- cents
    lifetime_payout INT DEFAULT 0,
    FOREIGN KEY(user_id) REFERENCES users(uuid)
);

CREATE TABLE chores (
    uuid VARCHAR(255) PRIMARY KEY,
    user_id VARCHAR(255) NOT NULL,
    child_id VARCHAR(255) DEFAULT NULL,
    name VARCHAR ( 255 ) NOT NULL,
    description VARCHAR ( 5000 ),
    bounty INT DEFAULT 0, -- cents
    is_done BOOL DEFAULT false,
    FOREIGN KEY(user_id) REFERENCES users(uuid),
    FOREIGN KEY(child_id) REFERENCES children(uuid)
);
