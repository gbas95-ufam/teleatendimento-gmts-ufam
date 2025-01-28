package teleatendimento

class Teleconsulta {
	Long id
	Consulta consulta
	Boolean gravacao
	Boolean consentimento

	static belongsTo = [consulta: Consulta]  // Relacionamento com Consulta

	static constraints = {
    	gravacao nullable: false
    	consentimento nullable: false
	}
}
