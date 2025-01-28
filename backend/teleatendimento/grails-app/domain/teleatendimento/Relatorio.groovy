package teleatendimento

class Relatorio {
	Long id
	String dadosAgendamento
	String tempoConsulta
	String localidade
	String formato
	Profissional profissional
	Paciente paciente

	static constraints = {
    	dadosAgendamento nullable: false, maxSize: 255
    	tempoConsulta nullable: false, maxSize: 255
    	localidade nullable: false, maxSize: 255
    	formato nullable: false, maxSize: 50
	}
}
