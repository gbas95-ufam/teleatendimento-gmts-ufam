package teleatendimento

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class ConsultaControllerSpec extends Specification implements ControllerUnitTest<ConsultaController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
