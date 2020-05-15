package es.uma.informatica.sii.agendaee.entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Curriculum
 *
 */
@Entity

public class Curriculum implements Serializable {

	public enum diasSemana {
		LUNES,
		MARTES,
		MIERCOLES,
		JUEVES,
		VIERNES,
		SABADO,
		DOMINGO
	};
	
	public enum idioma {
		INGLES,
		ALEMAN,
		FRANCES,
		ESPAÑOL
	};
	
	@Id
	private String id;
	
	@OneToOne
	private Alumno alumno;
	@Column(nullable = false)
	private String idiomas;
	@Column(nullable = false)
	private String experienciaLaboral;
	@Column(nullable = false)
	private String disponibilidadHoraria;
	private static final long serialVersionUID = 1L;

	@ManyToMany
	private List<Asignaturas> compuestoDe;
	
	public Curriculum() {
		super();
	}   
	/*
	public Curriculum(Long id, String idiomas, String eL, String dh, List<Asignaturas> asig) {
		this.id = id;
		this.idiomas = idiomas;
		this.experienciaLaboral = eL;
		this.disponibilidadHoraria = dh;
		this.compuestoDe = asig;
	}
	*/
	
	/*
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
*/
	public String getIdiomas() {
		return this.idiomas;
	}

	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}   
	public String getExperienciaLaboral() {
		return this.experienciaLaboral;
	}

	public void setExperienciaLaboral(String experienciaLaboral) {
		this.experienciaLaboral = experienciaLaboral;
	}   
	public String getDisponibilidadHoraria() {
		return this.disponibilidadHoraria;
	}

	public void setDisponibilidadHoraria(String disponibilidadHoraria) {
		this.disponibilidadHoraria = disponibilidadHoraria;
	}

	public List<Asignaturas> getCompuestoDe() {
		return compuestoDe;
	}

	public void setCompuestoDe(List<Asignaturas> compuestoDe) {
		this.compuestoDe = compuestoDe;
	}
   
}
