package teleatendimento

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ConsultaSpec extends Specification implements DomainUnitTest<Consulta> {

     void "test domain constraints"() {
        when:
        Consulta domain = new Consulta()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
