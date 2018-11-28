package com.example.dataindexer.userservice.user

import com.example.dataindexer.userservice.test.RestTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.jdbc.Sql
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

@SpringBootTest(webEnvironment = RANDOM_PORT, properties = ["indexer.property=my property"])
@Sql(statements = "INSERT INTO user (id, first_name, last_name) VALUES (-1, 'name', 'surname')")
@Transactional
class UserDTORemoteServiceControllerSpec extends Specification implements RestTest {
    @Autowired
    UserRemoteServiceController userRemoteServiceController

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
        when: "read user from service"
        def user = restTemplate.getForObject(getUrlFrom("user/read?id=-1", localHostPort), UserDTO)

        then: "check if user is present"
        with(user) {
            firstName == 'name'
            lastName == "surname"
        }
    }
}
