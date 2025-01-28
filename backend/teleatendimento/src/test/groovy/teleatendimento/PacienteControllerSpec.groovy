package teleatendimento

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class PacienteControllerSpec extends Specification implements ControllerUnitTest<PacienteController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
