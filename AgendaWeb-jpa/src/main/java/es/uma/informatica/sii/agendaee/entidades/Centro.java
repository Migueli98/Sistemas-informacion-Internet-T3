package es.uma.informatica.sii.agendaee.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	
	@OneToMany(mappedBy="centro")
	private List<Asignaturas> asignaturas;
	
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
	public List<Asignaturas> getAsignaturas() {
		return asignaturas;
	}
	public void setAsignaturas(List<Asignaturas> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	
	
   
}
