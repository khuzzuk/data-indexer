package com.example.dataindexer.userservice.user

import com.example.dataindexer.userservice.test.RestTest
import com.example.dataindexer.userservice.user.model.Role
import com.example.dataindexer.userservice.user.model.User
import com.example.dataindexer.userservice.user.model.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

@SpringBootTest(webEnvironment = RANDOM_PORT)
class UserDTORemoteServiceControllerSpec extends Specification implements RestTest {
    @Autowired
    UserRemoteServiceController userRemoteServiceController

    @Autowired
    UserRepository userRepository

    @LocalServerPort
    int localHostPort

    @Autowired
    TestRestTemplate restTemplate

    def "check context"() {
        expect: "check if user remote service controller is present in context"
        userRemoteServiceController
        localHostPort > 0
    }

    def "test user read"() {
        given:
        User user = new User()
        user.setFirstName('name')
        user.setLastName('last name')
        user.setUsername('username')
        user.setPassword('password')

        Role role = new Role()
        role.setName('USER')
        user.setRoles(Set.of(role))

        userRepository.save(user)

        when: "read user from service"
        def result = restTemplate.getForObject(getUrlFrom("user/read?id=1", localHostPort), UserDTO)

        then: "check if user is present"
        with(result) {
            firstName == 'name'
            lastName == "last name"
        }
    }
}
