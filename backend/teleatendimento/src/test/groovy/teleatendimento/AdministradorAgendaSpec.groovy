package teleatendimento

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class AdministradorAgendaSpec extends Specification implements DomainUnitTest<AdministradorAgenda> {

     void "test domain constraints"() {
        when:
        AdministradorAgenda domain = new AdministradorAgenda()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
