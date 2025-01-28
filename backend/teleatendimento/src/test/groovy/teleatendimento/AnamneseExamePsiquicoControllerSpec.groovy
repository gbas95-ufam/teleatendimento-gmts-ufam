package teleatendimento

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class AnamneseExamePsiquicoControllerSpec extends Specification implements ControllerUnitTest<AnamneseExamePsiquicoController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
