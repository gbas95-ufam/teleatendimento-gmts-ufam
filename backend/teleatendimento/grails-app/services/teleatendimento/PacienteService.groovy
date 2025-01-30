package teleatendimento

import grails.gorm.transactions.Transactional

@Transactional
class PacienteService {

    def save(Paciente paciente) {
        if (paciente.validate()) {
            paciente.save(flush: true)
            return paciente
        } else {
            return null  // ou lançar uma exceção, dependendo do caso de uso
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

    def Paciente findById(Long id) {
        return Paciente.get(id)
    }

    def List<Paciente> findAll() {
        return Paciente.list()
    }
}
