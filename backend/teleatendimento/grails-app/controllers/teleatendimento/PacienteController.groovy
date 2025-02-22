package teleatendimento
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.HttpStatus

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
        if (pacienteService.save(paciente)) {
            respond paciente, [status: CREATED, location: g.link(action: 'show', id: paciente.id)]
        } else {
            render status: BAD_REQUEST, text: 'Invalid Paciente data'
        }
    }

    @Transactional
    def update(Long id) {
        Paciente existingPaciente = pacienteService.findById(id)
        if (existingPaciente) {
            existingPaciente.properties = params
            if (pacienteService.save(existingPaciente)) {
                respond existingPaciente
            } else {
                render status: BAD_REQUEST, text: 'Invalid Paciente data'
            }
        } else {
            render status: NOT_FOUND, text: 'No Paciente found with id $id'
        }
    }

    @Transactional
    def delete(Long id) {
        if (pacienteService.delete(id)) {
            render status: NO_CONTENT
        } else {
            render status: NOT_FOUND, text: 'No Paciente found with id $id'
        }
    }
}
