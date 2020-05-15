package es.uma.informatica.sii.agendaee.entidades;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Centro
 *
 */
@Entity

public class Centro implements Serializable {

	   
	@Id @GeneratedValue
	private Long codigoCentro;
	@Column(nullable = false)
	private String nombreCentro;
	
	private static final long serialVersionUID = 1L;

	public Centro() {
		super();
	}   
	public Long getCodigoCentro() {
		return this.codigoCentro;
	}

	public void setCodigoCentro(Long codigoCentro) {
		this.codigoCentro = codigoCentro;
	}   
	public String getNombreCentro() {
		return this.nombreCentro;
	}

	public void setNombreCentro(String nombreCentro) {
		this.nombreCentro = nombreCentro;
	}
   
}
