package teleatendimento

class AdministradorPaciente implements Serializable{
	Administrador administrador
	Paciente paciente

	static constraints = {}
	static mapping = {
    	id composite: ['administrador', 'paciente']
	}
}
