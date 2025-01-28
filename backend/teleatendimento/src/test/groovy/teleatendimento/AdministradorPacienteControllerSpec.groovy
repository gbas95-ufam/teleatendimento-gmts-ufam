package teleatendimento

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class AdministradorPacienteControllerSpec extends Specification implements ControllerUnitTest<AdministradorPacienteController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
