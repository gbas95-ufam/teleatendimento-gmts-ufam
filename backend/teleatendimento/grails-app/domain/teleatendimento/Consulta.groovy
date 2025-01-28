package teleatendimento

class Consulta {
	Long id
	Paciente paciente
	Agenda agenda
	String linkConsulta
	String notificacoes

	static belongsTo = [paciente: Paciente, agenda: Agenda]  // Relacionamento com Paciente e Agenda

	static constraints = {
    	linkConsulta nullable: false, maxSize: 255
    	notificacoes nullable: true, maxSize: 255
	}
}
