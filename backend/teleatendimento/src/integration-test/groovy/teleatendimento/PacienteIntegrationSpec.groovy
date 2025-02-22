package teleatendimento

import grails.testing.mixin.integration.Integration
import spock.lang.Specification

@Integration
@Transactional
class PacienteIntegrationSpec extends Specification {

    void "testar persistência e recuperação de Paciente com Localidade"() {
        given: "uma instância válida de Localidade"
        def localidade = new Localidade(
            nome: "Localidade A",
            conexaoMinima: "Conexão 4G",
            regiaoRemota: false
        ).save(flush: true, failOnError: true)

        and: "um objeto Paciente associado à Localidade"
        def paciente = new Paciente(
            nome: "João da Silva",
            idade: 40,
            sexo: "Masculino",
            problemaSaude: "Hipertensão",
            contato: "joao@example.com",
            localidade: localidade
        )

        when: "salvamos o Paciente"
        paciente.save(flush: true, failOnError: true)

        then: "o Paciente é persistido corretamente"
        !paciente.hasErrors()
        paciente.id != null
        Paciente.count() == 1

        when: "recuperamos o Paciente pelo ID"
        def recuperado = Paciente.get(paciente.id)

        then: "os dados persistidos correspondem aos esperados"
        recuperado.nome == "João da Silva"
        recuperado.idade == 40
        recuperado.sexo == "Masculino"
        recuperado.problemaSaude == "Hipertensão"
        recuperado.contato == "joao@example.com"
        recuperado.localidade == localidade
    }
}
