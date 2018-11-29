package com.example.dataindexer.userservice.test


import org.springframework.test.context.jdbc.Sql

import java.lang.annotation.*

@Retention(RetentionPolicy.RUNTIME)
@Target([ElementType.TYPE])
@Inherited
@Documented
@Sql(statements = """
        INSERT INTO user (id, first_name, last_name, username, password) 
VALUES (-1, 'name', 'surname', 'user name', 'password');
        INSERT INTO role (id, name) VALUES (-2, 'USER');
        INSERT INTO user_roles(user_id, roles_id) VALUES (-1, -2);
        """)
@interface UserTest {
}