package teleatendimento

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PacienteSpec extends Specification implements DomainUnitTest<Paciente> {

     void "test domain constraints"() {
        when:
        Paciente domain = new Paciente()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
