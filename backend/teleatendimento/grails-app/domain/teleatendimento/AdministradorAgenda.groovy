package teleatendimento

class AdministradorAgenda {
	Administrador administrador
	Agenda agenda

	static constraints = {}
	static mapping = {
    	id composite: ['administrador', 'agenda']
	}
}
