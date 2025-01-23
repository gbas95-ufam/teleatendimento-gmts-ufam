package teleatendimento

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class AnamneseExamePsiquicoSpec extends Specification implements DomainUnitTest<AnamneseExamePsiquico> {

     void "test domain constraints"() {
        when:
        AnamneseExamePsiquico domain = new AnamneseExamePsiquico()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
