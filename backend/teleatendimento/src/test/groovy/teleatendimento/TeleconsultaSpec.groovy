package teleatendimento

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class TeleconsultaSpec extends Specification implements DomainUnitTest<Teleconsulta> {

     void "test domain constraints"() {
        when:
        Teleconsulta domain = new Teleconsulta()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
