package teleatendimento

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class AdministradorControllerSpec extends Specification implements ControllerUnitTest<AdministradorController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
