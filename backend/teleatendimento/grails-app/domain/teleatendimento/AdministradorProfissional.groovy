package teleatendimento

class AdministradorProfissional {
	Administrador administrador
	Profissional profissional

	static constraints = {}
	static mapping = {
    	id composite: ['administrador', 'profissional']
	}
}
