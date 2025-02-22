package teleatendimento

class AdministradorAgenda implements Serializable {
	Administrador administrador
	Agenda agenda

	static constraints = {}
	static mapping = {
    	id composite: ['administrador', 'agenda']
	}
}
