package com.example.dataindexer.userservice.user.model

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification
import spock.lang.Stepwise

@DataJpaTest
@Stepwise
@Transactional
class UserRepositorySpec extends Specification {
    @Autowired
    UserRepository userRepository
    @Autowired
    RoleRepository roleRepository

    def "test save user"() {
        given: "create user"
        Role role = new Role()
        role.setName('USER')
        role = roleRepository.save(role)

        User user = new User()
        user.firstName = 'first name'
        user.lastName = 'last name'
        user.setRoles(Set.of(role))

        User user2 = new User()
        user2.firstName = 'first name'
        user2.lastName = 'last name'

        when: "save user"
        userRepository.save(user)
        userRepository.save(user2)

        def users = userRepository.findAll()

        then: "saved one user"
        users.size() == 2
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
