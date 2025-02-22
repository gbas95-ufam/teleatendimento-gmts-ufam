package teleatendimento
import grails.persistence.*
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@Entity
@JsonIgnoreProperties(['dirtyPropertyNames', 'errors', 'dirty', 'attached', 'version'])
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
