package teleatendimento

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class AdministradorPacienteSpec extends Specification implements DomainUnitTest<AdministradorPaciente> {

    void "test valid AdministradorPaciente instance"() {
        given: "um administrador, uma localidade e um paciente válidos"
        def administrador = new Administrador(nome: "Admin", credenciais: "secret")
        def localidade = new Localidade(nome: "Localidade 1", conexaoMinima: "1Gbps", regiaoRemota: false)
        def paciente = new Paciente(nome: "Paciente 1", idade: 30, sexo: "Masculino", contato: "123456789", localidade: localidade)
        
        // Salvamos as instâncias para que possam ser referenciadas
        administrador.save(flush: true)
        localidade.save(flush: true)
        paciente.save(flush: true)

        when: "criamos uma instância de AdministradorPaciente com ambos os campos preenchidos"
        def adminPaciente = new AdministradorPaciente(administrador: administrador, paciente: paciente)

        then: "a instância deve validar"
        adminPaciente.validate()
    }

    void "test AdministradorPaciente instance is invalid when administrador is null"() {
        given: "um paciente válido"
        def localidade = new Localidade(nome: "Localidade 1", conexaoMinima: "1Gbps", regiaoRemota: false)
        def paciente = new Paciente(nome: "Paciente 1", idade: 30, sexo: "Masculino", contato: "123456789", localidade: localidade)
        
        localidade.save(flush: true)
        paciente.save(flush: true)

        when: "criamos uma instância de AdministradorPaciente sem definir o administrador"
        def adminPaciente = new AdministradorPaciente(administrador: null, paciente: paciente)

        then: "a instância não deve validar e deve conter erro no campo administrador"
        !adminPaciente.validate()
        adminPaciente.errors.getFieldError('administrador') != null
    }

    void "test AdministradorPaciente instance is invalid when paciente is null"() {
        given: "um administrador válido"
        def administrador = new Administrador(nome: "Admin", credenciais: "secret")
        administrador.save(flush: true)

        when: "criamos uma instância de AdministradorPaciente sem definir o paciente"
        def adminPaciente = new AdministradorPaciente(administrador: administrador, paciente: null)

        then: "a instância não deve validar e deve conter erro no campo paciente"
        !adminPaciente.validate()
        adminPaciente.errors.getFieldError('paciente') != null
    }
}
