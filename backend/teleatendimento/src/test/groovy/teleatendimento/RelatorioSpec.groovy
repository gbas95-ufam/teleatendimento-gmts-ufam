package teleatendimento

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class RelatorioSpec extends Specification implements DomainUnitTest<Relatorio> {

     void "test domain constraints"() {
        when:
        Relatorio domain = new Relatorio()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
