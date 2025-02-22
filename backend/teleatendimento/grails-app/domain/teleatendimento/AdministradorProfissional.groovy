package teleatendimento

class AdministradorProfissional implements Serializable{
	Administrador administrador
	Profissional profissional

	static constraints = {}
	static mapping = {
    	id composite: ['administrador', 'profissional']
	}
}
