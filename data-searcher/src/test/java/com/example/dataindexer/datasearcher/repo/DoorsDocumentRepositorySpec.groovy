package com.example.dataindexer.datasearcher.repo


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import spock.lang.Specification

@DataJpaTest
class DoorsDocumentRepositorySpec extends Specification {
    @Autowired
    DoorsDocumentRepository documentRepository

    def "mapping test"() {
        expect:
        documentRepository
    }
}
