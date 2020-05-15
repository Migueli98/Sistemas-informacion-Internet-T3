package es.uma.informatica.sii.agendaee.entidades;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;



/**
 * Entity implementation class for Entity: Actividades
 *
 */
@Entity

public class Actividades implements Serializable {



	public enum Estado {
	      PENDIENTE,
	      ACEPTADA,
	      EN_CURSO,
	      REALIZADA,
	      RECHAZADA,
	      BUSCANDO_PARTICIPANTES
	    };
	
	@Id @GeneratedValue
	private Long idActividad;
	@Column(nullable = false)
	private String nombreActividad;
	@Column(nullable = false)
	private String tipoActividad;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaActividad;
	@Column(nullable = false)
	private String lugarRealizacion;
	private String descripcion; 
	@Enumerated(EnumType.STRING)
	private Estado estado;


	@ManyToOne
	@JoinColumn(name = "servicio")
	private Servicios servicio;
	private static final long serialVersionUID = 1L;

	public Actividades() {
		super();
	}  
	
	public Actividades(Long id,String nombre, String tipo, Date fecha, String lugar, String descripcion, Estado estado) {
		nombreActividad=nombre;
		idActividad = id;
		tipoActividad = tipo;
		fechaActividad = fecha;
		lugarRealizacion = lugar;
		this.descripcion = descripcion;
		this.estado=estado;
	}

	
	public String getTipoActividad() {
		return this.tipoActividad;
	}

	
	public void setTipoActividad(String tipoActividad) {
		this.tipoActividad = tipoActividad;
	}   
	public Date getFechaActividad() {
		return this.fechaActividad;
	}

	public void setFechaActividad(Date fechaActividad) {
		this.fechaActividad = fechaActividad;
	}   
	public String getLugarRealizacion() {
		return this.lugarRealizacion;
	}

	public void setLugarRealizacion(String lugarRealizacion) {
		this.lugarRealizacion = lugarRealizacion;
	}   
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}   
	public Long getIdActividad() {
		return this.idActividad;
	}

	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}
	public Servicios getServicio() {
		return servicio;
	}
	public void setServicio(Servicios servicio) {
		this.servicio = servicio;
	}

	public String getNombreActividad() {
		return nombreActividad;
	}

	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
   
}
