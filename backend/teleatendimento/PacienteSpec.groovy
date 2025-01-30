package teleatendimento

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PacienteSpec extends Specification implements DomainUnitTest<Paciente> {

     def "test paciente instance with valid data"() {
        given: "a valid paciente instance"
        def paciente = new Paciente(nome: "João Silva", idade: 34, sexo: "Masculino", contato: "999888777", localidade: new Localidade(nome: "Zona Sul", conexaoMinima: "5Mbps", regiaoRemota: false))

        expect: "the paciente is valid"
        paciente.validate()
    }

    def "test paciente instance with invalid data"() {
        given: "a paciente instance with invalid data"
        def paciente = new Paciente(nome: "", idade: -1, sexo: "", contato: "")

        when: "validating paciente"
        def result = paciente.validate()

        then: "the paciente is invalid"
        !result
        paciente.errors.getFieldError('nome').rejectedValue == ""
        paciente.errors.getFieldError('idade').rejectedValue == -1
        paciente.errors.getFieldError('sexo').rejectedValue == ""
        paciente.errors.getFieldError('contato').rejectedValue == ""
    }
}
