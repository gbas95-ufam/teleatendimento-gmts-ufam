package teleatendimento

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class AdministradorSpec extends Specification implements DomainUnitTest<Administrador> {

     void "test domain constraints"() {
        when:
        Administrador domain = new Administrador()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
