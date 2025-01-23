package teleatendimento

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class AgendaSpec extends Specification implements DomainUnitTest<Agenda> {

     void "test domain constraints"() {
        when:
        Agenda domain = new Agenda()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
