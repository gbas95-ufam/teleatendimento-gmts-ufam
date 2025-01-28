package teleatendimento

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class AgendaControllerSpec extends Specification implements ControllerUnitTest<AgendaController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
