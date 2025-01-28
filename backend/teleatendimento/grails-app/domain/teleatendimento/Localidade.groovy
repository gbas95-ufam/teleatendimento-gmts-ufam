package teleatendimento

class Localidade {
	Long id
	String nome
	String conexaoMinima
	Boolean regiaoRemota

	static constraints = {
    	nome nullable: false, maxSize: 255
    	conexaoMinima nullable: false, maxSize: 255
    	regiaoRemota nullable: false
	}
}
