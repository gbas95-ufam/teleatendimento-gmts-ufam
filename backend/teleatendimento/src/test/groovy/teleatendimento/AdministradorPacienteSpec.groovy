package teleatendimento

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class AdministradorPacienteSpec extends Specification implements DomainUnitTest<AdministradorPaciente> {

     void "test domain constraints"() {
        when:
        AdministradorPaciente domain = new AdministradorPaciente()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
