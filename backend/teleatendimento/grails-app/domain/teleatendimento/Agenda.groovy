package teleatendimento

class Agenda {
	Long id
	Profissional profissional
	Date data
	Time horario
	String status

	static belongsTo = [profissional: Profissional]  // Relacionamento com Profissional

	static constraints = {
    	data nullable: false
    	horario nullable: false
    	status nullable: false, maxSize: 50
	}
}
