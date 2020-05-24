
package es.uma.informatica.sii.agendaee.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;



/**
 * Entity implementation class for Entity: Inscripciones
 *
 */
@Entity

@NamedQueries({
    @NamedQuery(name="findInscripciones",query="select i from Inscripciones i where i.usuario= :user"),
    @NamedQuery(name="findInscripcionesUserAct",query="select i from Inscripciones i where i.usuario= :user and i.actividad= :actividad")
	})

public class Inscripciones implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public enum estadoInscripcion{
		ACEPTADO,
		ESPERANDO,
		RECHAZADO
	};
	
	
	@Id @GeneratedValue
	private Long id;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaInscripcion;
	@Enumerated(EnumType.STRING)
	private estadoInscripcion estado;
	
	
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuario;
	
	
	@ManyToOne
	@JoinColumn(name="actividad")
	private Actividades actividad;

	public Inscripciones() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public estadoInscripcion getEstado() {
		return estado;
	}

	public void setEstado(estadoInscripcion estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Actividades getActividad() {
		return actividad;
	}

	public void setActividad(Actividades actividad) {
		this.actividad = actividad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inscripciones other = (Inscripciones) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	


	
}
