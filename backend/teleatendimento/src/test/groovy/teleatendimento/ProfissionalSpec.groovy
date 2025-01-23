package teleatendimento

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ProfissionalSpec extends Specification implements DomainUnitTest<Profissional> {

     void "test domain constraints"() {
        when:
        Profissional domain = new Profissional()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
