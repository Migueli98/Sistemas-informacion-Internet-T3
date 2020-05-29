package es.uma.informatica.sii.agendaee.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@NamedQueries({
    @NamedQuery(name="findActividadesEstado",query="select a from Actividades a where a.estado= :est"),
    @NamedQuery(name="findActividades",query="select a from Actividades a where a.idActividad= :id"),
    @NamedQuery(name="findAllActividades",query="select a from Actividades a")})

public class Actividades implements Serializable {

	private static final long serialVersionUID = 1L;

	public enum Estado {
	      PENDIENTE,
	      ACEPTADA,
	      EN_CURSO,
	      REALIZADA,
	      RECHAZADA,
	      BUSCANDO_PARTICIPANTES
	    };
	    
	/*public enum Tipo{
		VOLUNTARIADO,
		APYS,
		FORMACION
	};
	*/
	
	@Id @GeneratedValue
	private Long idActividad;
	@Column(nullable = false)
	private String nombreActividad;
	@Column(nullable = false)
	private String tipoActividad;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaInicioActividad;
	@Temporal(TemporalType.DATE)
	private Date fechaFinActividad;
	@Column(nullable = false)
	private String lugarRealizacion;
	private String descripcion; 
	@Enumerated(EnumType.STRING)
	private Estado estado;
	private String idiomas;
	private String experienciaLaboral;
	private String disponibilidad;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "servicio")
	private Servicios servicio;
	
	@OneToMany(mappedBy="actividades")
	private List<InformeActividades> informes;
	
	@OneToMany(mappedBy="actividad")
	private List<Inscripciones> inscripciones;
	
	
	

	public Actividades() {
		super();
	}  

	public Date getFechaInicioActividad() {
		return fechaInicioActividad;
	}

	public String getTipoActividad() {
		return tipoActividad;
	}



	public void setTipoActividad(String tipoActividad) {
		this.tipoActividad = tipoActividad;
	}



	public void setFechaInicioActividad(Date fechaInicioActividad) {
		this.fechaInicioActividad = fechaInicioActividad;
	}

	public Date getFechaFinActividad() {
		return fechaFinActividad;
	}

	public void setFechaFinActividad(Date fechaFinActividad) {
		this.fechaFinActividad = fechaFinActividad;
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

	public List<InformeActividades> getInformes() {
		return informes;
	}

	public void setInformes(List<InformeActividades> informes) {
		this.informes = informes;
	}

	public List<Inscripciones> getInscripciones() {
		return inscripciones;
	}

	public void setInscripciones(List<Inscripciones> inscripciones) {
		this.inscripciones = inscripciones;
	}

	public String getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}

	public String getExperienciaLaboral() {
		return experienciaLaboral;
	}

	public void setExperienciaLaboral(String experienciaLaboral) {
		this.experienciaLaboral = experienciaLaboral;
	}

	public String getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	
	
	
   
}
