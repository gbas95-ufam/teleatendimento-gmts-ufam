package teleatendimento

import grails.gorm.transactions.Transactional
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import groovy.util.logging.Slf4j

@Slf4j
@Transactional
class PacienteService {

    //private static final Logger log = LoggerFactory.getLogger(PacienteService)

    def save(Paciente paciente) {
        try {
            if (paciente.validate()) {
                paciente.save(flush: true)
                log.info("Paciente salvo com sucesso: ${paciente.id}")
                return paciente
            } else {
                log.error("Falha na validação do paciente: ${paciente.errors}")
                return null
            }
        } catch (Exception e) {
            log.error("Erro ao salvar paciente: ${e.message}", e)
            throw e  // Você pode optar por propagar a exceção ou retornar um objeto de erro
        }
    }

    def delete(Long id) {
        Paciente paciente = Paciente.get(id)
        if (paciente) {
            paciente.delete(flush: true)
            return true
        }
        return false
    }

    def update(Long id, Map<String, Object>updates){
        def paciente = Paciente.get(id)

        if(!paciente){ //Checa se o retorno foi nulo ou não
            return [erro404: "Paciente com id: ${id} não encontrado"]
        }

        updates.each { key, value
            if(paciente.hasProperty(key)){ // Garante que somente propriedades validas(atributos) serão atualizados
                paciente[key] = value
            }
        }
 
        if(!paciente.save(flush: true)){ // Checa se o save foi possível no banco de dados
            return [erro: "Erro ao atualizar o paciente. \nErros: ${paciente.erros}"]
        }

        return [sucesso: "Paciente atualizado com sucesso\n"]
    }

    def Paciente findById(Long id) {
        return Paciente.get(id)
    }

    def List<Paciente> findAll() {
        return Paciente.list()
    }
}
