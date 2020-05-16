package es.uma.informatica.sii.agendaee.entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Requisitos
 *
 */
@Entity

public class Requisitos implements Serializable {
	
	private enum diasSemana {
		LUNES,
		MARTES,
		MIERCOLES,
		JUEVES,
		VIERNES,
		SABADO,
		DOMINGO
	};
	
	private enum idioma {
		INGLES,
		ALEMAN,
		FRANCES,
		ESPAÑOL
	};

	@Id @GeneratedValue
	private Long id;
	@Column(nullable = false)
	private idioma idiomas;
	@Column(nullable = false)
	private String experienciaLaboral;
	@Column(nullable = false)
	private diasSemana disponibilidadHoraria;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "servicio")
	private Servicios servicio;
	
	@ManyToMany
	private List<Asignaturas> requieren;

	public Requisitos() {
		super();
	}   
	
	public idioma getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(idioma idiomas) {
		this.idiomas = idiomas;
	}

	public diasSemana getDisponibilidadHoraria() {
		return disponibilidadHoraria;
	}

	public void setDisponibilidadHoraria(diasSemana disponibilidadHoraria) {
		this.disponibilidadHoraria = disponibilidadHoraria;
	}

	public String getExperienciaLaboral() {
		return this.experienciaLaboral;
	}

	public void setExperienciaLaboral(String experienciaLaboral) {
		this.experienciaLaboral = experienciaLaboral;
	}   
	
	
	public Servicios getServicio() {
		return servicio;
	}
	public void setServicio(Servicios servicio) {
		this.servicio = servicio;
	}
	public List<Asignaturas> getRequieren() {
		return requieren;
	}
	public void setRequieren(List<Asignaturas> requieren) {
		this.requieren = requieren;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
   
}
