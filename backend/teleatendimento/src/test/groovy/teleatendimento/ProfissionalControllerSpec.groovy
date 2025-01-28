package teleatendimento

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class ProfissionalControllerSpec extends Specification implements ControllerUnitTest<ProfissionalController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
