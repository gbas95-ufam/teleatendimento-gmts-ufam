package teleatendimento

class Administrador {
	Long id
	String nome
	String credenciais

	static constraints = {
    	nome nullable: false, maxSize: 255
    	credenciais nullable: false, maxSize: 255
	}
}
