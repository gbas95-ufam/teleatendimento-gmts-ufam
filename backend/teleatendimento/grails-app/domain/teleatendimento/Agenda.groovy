package teleatendimento
import java.time.*

class Agenda {
	Long id
	Profissional profissional
	LocalDate data
	LocalTime horario
	String status

	static belongsTo = [profissional: Profissional]  // Relacionamento com Profissional

	static constraints = {
    	data nullable: false
    	horario nullable: false
    	status nullable: false, maxSize: 50
	}
}
