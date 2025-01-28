package teleatendimento

class Paciente {
	Long id
	String nome
	Integer idade
	String sexo
	String problemaSaude
	String contato
	Localidade localidade

	static belongsTo = [localidade: Localidade]  // Relacionamento com Localidade

	static constraints = {
    	nome nullable: false, maxSize: 255
    	idade nullable: false, min: 0
    	sexo nullable: false, maxSize: 50
    	problemaSaude nullable: true, maxSize: 255
    	contato nullable: false, maxSize: 255
	}
}
