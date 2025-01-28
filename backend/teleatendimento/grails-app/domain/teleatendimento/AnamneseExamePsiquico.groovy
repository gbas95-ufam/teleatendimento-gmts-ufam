package teleatendimento

class AnamneseExamePsiquico {
	Long id
	Paciente paciente
	String tipoConsulta
	String dados
	Date dataConsulta

	static belongsTo = [paciente: Paciente]  // Relacionamento com Paciente

	static constraints = {
    	tipoConsulta nullable: false, maxSize: 50
    	dados nullable: true
    	dataConsulta nullable: false
	}
}
