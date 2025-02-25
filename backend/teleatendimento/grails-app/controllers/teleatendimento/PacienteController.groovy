package teleatendimento
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import static org.springframework.http.HttpStatus.*

@RestController
class PacienteController {

    PacienteService pacienteService

    @RequestMapping("/pacientes")
    @Transactional(readOnly = true)
    public List<String> list() {
        respond pacienteService.findAll()
    }

    @Transactional(readOnly = true)
    def show(Long id) {
        Paciente paciente = pacienteService.findById(id)
        respond paciente != null ? paciente : [status: NOT_FOUND]
    }

    @Transactional
    def save() {
        Paciente paciente = new Paciente(params)
        render "Paciente criado com os parametros: ${params}"
        if (pacienteService.save(paciente)) {
            // respond paciente, [status: CREATED]
            render status: CREATED, text: "Paciente cadastrado"
        } else {
            render status: BAD_REQUEST, text: "Invalid Paciente data"
        }
    }

    @Transactional
    def update(Long id) {
        Paciente existingPaciente = pacienteService.findById(id)
        render "Antes do update: ${existingPaciente.properties}"
        if (existingPaciente) {
            existingPaciente.properties = params
            render "Depois do update: ${existingPaciente.properties}"
            if (pacienteService.save(existingPaciente)) {
                // respond existingPaciente
                render status: CREATED, text: "Paciente atualizado"
            } else {
                render status: BAD_REQUEST, text: "Invalid Paciente data"
            }
        } else {
            render status: NOT_FOUND, text: "No Paciente found with id ${id}"
        }
    }

    @Transactional
    def delete(Long id) {
        if (pacienteService.delete(id)) {

            render status: FOUND, text: "Paciente excluido com sucesso"
        } else {
            render status: NOT_FOUND, text: "No Paciente found with id ${id}"
        }
    }
}
