package teleatendimento

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import ch.qos.logback.classic.Logger
import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.read.ListAppender
import org.slf4j.LoggerFactory

class PacienteSpec extends Specification implements DomainUnitTest<Paciente> {

    def "test save paciente with valid data"() {
        given: "uma instância válida de Paciente e uma Localidade associada"
        def localidade = new Localidade(nome: "Zona Sul", conexaoMinima: "5Mbps", regiaoRemota: false)
        // Salvar a localidade se necessário para persistência (ou mockar, se estiver utilizando DomainUnitTest)
        localidade.save(flush: true)
        
        def paciente = new Paciente(
            nome: "João Silva",
            idade: 34,
            sexo: "Masculino",
            contato: "999888777",
            localidade: localidade
        )
        
        when: "o paciente é salvo"
        paciente.save(flush: true)
        
        then: "o paciente é persistido sem erros e um ID é gerado"
        !paciente.hasErrors()
        paciente.id != null
        Paciente.count() == 1
        Paciente.get(paciente.id)?.nome == "João Silva"

        println "O id gerado foi: ${paciente.id}"

    }

    def "test save invalid paciente logs error"() {
        given: "um paciente inválido (dados faltantes) e configuração para capturar logs do PacienteService"
        def paciente = new Paciente(nome: "", idade: -1, sexo: "", contato: "", localidade: null)
        
        // Configurar o ListAppender para capturar os logs
        Logger logger = (Logger) LoggerFactory.getLogger(PacienteService)
        ListAppender<ILoggingEvent> listAppender = new ListAppender<>()
        listAppender.start()
        logger.addAppender(listAppender)
        
        when: "tentamos salvar o paciente usando o PacienteService"
        PacienteService service = new PacienteService()
        service.save(paciente)
        
        then: "a validação falha e é gerado um log de erro"
        !paciente.validate()
        def logMessages = listAppender.list*.message
        // Verifica se algum dos logs contém a mensagem de falha na validação
        logMessages.any { it.contains("Falha na validação") }
        
        cleanup:
        logger.detachAppender(listAppender)
    }
}
