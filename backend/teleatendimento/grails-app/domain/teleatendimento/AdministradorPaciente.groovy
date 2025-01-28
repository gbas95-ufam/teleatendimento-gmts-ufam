package teleatendimento

class AdministradorPaciente {
	Administrador administrador
	Paciente paciente

	static constraints = {}
	static mapping = {
    	id composite: ['administrador', 'paciente']
	}
}
