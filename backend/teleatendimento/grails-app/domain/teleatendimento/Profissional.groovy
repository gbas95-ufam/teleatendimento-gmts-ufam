package teleatendimento

class Profissional {
	Long id
	String nome
	String especialidade
	String disponibilidade

	static constraints = {
    	nome nullable: false, maxSize: 255
    	especialidade nullable: false, maxSize: 255
    	disponibilidade nullable: false, maxSize: 255
	}
}
