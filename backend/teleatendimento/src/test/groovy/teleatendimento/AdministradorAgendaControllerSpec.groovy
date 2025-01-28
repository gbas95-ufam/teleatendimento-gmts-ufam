package teleatendimento

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class AdministradorAgendaControllerSpec extends Specification implements ControllerUnitTest<AdministradorAgendaController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
