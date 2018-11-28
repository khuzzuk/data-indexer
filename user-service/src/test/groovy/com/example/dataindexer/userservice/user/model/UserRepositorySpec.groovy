package com.example.dataindexer.userservice.user.model

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification
import spock.lang.Stepwise

@SpringBootTest
@Stepwise
@Transactional
class UserRepositorySpec extends Specification {
    @Autowired
    UserRepository userRepository

    def "test save user"() {
        given: "create user"
        User user = new User()
        user.firstName = 'first name'
        user.lastName = 'last name'

        when: "save user"
        userRepository.save(user)

        def users = userRepository.findAll()

        then: "saved one user"
        users.size() == 1
        with(users.get(0)) {
            firstName == 'first name'
            lastName == 'last name'
            addresses == null
        }
    }

    def "check clean database"() {
        expect: "no entities saved"
        userRepository.findAll().size() == 0
    }
}
