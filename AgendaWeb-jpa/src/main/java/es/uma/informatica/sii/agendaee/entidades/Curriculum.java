package es.uma.informatica.sii.agendaee.entidades;

import java.io.Serializable;
import java.lang.String;

import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Curriculum
 *
 */
@Entity

public class Curriculum implements Serializable {

	private static final long serialVersionUID = 1L;
	
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
	
	@Id
	private Long id;
	
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private idioma idiomas;
	@Column(nullable = false)
	private String experienciaLaboral;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private diasSemana disponibilidadHoraria;
	

	@ManyToMany
	private List<Asignaturas> compuestoDe;
	@OneToOne
	private Alumno alumno;
	
	
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
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExperienciaLaboral() {
		return this.experienciaLaboral;
	}


	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
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

	public void setExperienciaLaboral(String experienciaLaboral) {
		this.experienciaLaboral = experienciaLaboral;
	}   
	

	public List<Asignaturas> getCompuestoDe() {
		return compuestoDe;
	}

	public void setCompuestoDe(List<Asignaturas> compuestoDe) {
		this.compuestoDe = compuestoDe;
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
		Curriculum other = (Curriculum) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
   
}
