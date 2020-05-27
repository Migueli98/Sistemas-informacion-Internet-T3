package es.uma.informatica.sii.agendaee.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: Curriculum
 *
 */
@Entity
@NamedQueries({
    @NamedQuery(name="findCurriculum",query="select cu from Curriculum cu where cu.id= :id")})
public class Curriculum implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public enum DiasSemana {
		LUNES,
		MARTES,
		MIERCOLES,
		JUEVES,
		VIERNES,
		SABADO,
		DOMINGO
	};
	
	public enum Idioma {
		INGLES,
		ALEMAN,
		FRANCES
	};
	
	@Id @GeneratedValue
	private Long id;
	
	
	@Column(nullable = false)
	@ElementCollection
	private List<Idioma> idiomas = new ArrayList<>();
	@Column(nullable = false)
	private String experienciaLaboral;
	@Column(nullable = false)
	@ElementCollection
	private List<DiasSemana> disponibilidadSemanal = new ArrayList<>();
	

	@ManyToMany
	@JoinTable(name = "jnd_curriculum_asignaturas",
	joinColumns = @JoinColumn(name = "curriculum_fk"),
	inverseJoinColumns = @JoinColumn(name = "asignaturas_fk")
	)
	
	private List<Asignaturas> compuestoDe;
	
	@OneToOne(mappedBy = "cv")
	private Alumno alumno;
	
	
	public Curriculum() {
		super();
	}  
	
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



	public void setExperienciaLaboral(String experienciaLaboral) {
		this.experienciaLaboral = experienciaLaboral;
	}   
	

	public List<Asignaturas> getCompuestoDe() {
		return compuestoDe;
	}

	public void setCompuestoDe(List<Asignaturas> compuestoDe) {
		this.compuestoDe = compuestoDe;
	}

	

	public List<Idioma> getIdiomas() {
		return idiomas;
	}


	public void setIdiomas(List<Idioma> idiomas) {
		this.idiomas = idiomas;
	}


	public List<DiasSemana> getDisponibilidadSemanal() {
		return disponibilidadSemanal;
	}


	public void setDisponibilidadSemanal(List<DiasSemana> disponibilidadSemanal) {
		this.disponibilidadSemanal = disponibilidadSemanal;
	}
	
	public void addIdiomas(Idioma i) {
		idiomas.add(i);
	}
	
	public void removeIdiomas(Idioma i) {
		idiomas.remove(i);
	}
	
	public void addDisponibilidadSemanal(DiasSemana d) {
		disponibilidadSemanal.add(d);
	}
	
	public void removeDisponibilidadSemanal(DiasSemana d) {
		disponibilidadSemanal.remove(d);
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
