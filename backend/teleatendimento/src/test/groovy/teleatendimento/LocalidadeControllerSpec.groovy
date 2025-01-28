package teleatendimento

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class LocalidadeControllerSpec extends Specification implements ControllerUnitTest<LocalidadeController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
