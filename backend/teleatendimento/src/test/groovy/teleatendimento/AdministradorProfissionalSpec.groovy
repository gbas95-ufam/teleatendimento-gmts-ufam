package teleatendimento

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class AdministradorProfissionalSpec extends Specification implements DomainUnitTest<AdministradorProfissional> {

     void "test domain constraints"() {
        when:
        AdministradorProfissional domain = new AdministradorProfissional()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
