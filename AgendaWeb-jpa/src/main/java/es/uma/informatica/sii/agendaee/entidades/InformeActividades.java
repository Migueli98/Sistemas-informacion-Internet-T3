package es.uma.informatica.sii.agendaee.entidades;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;


/**
 * Entity implementation class for Entity: Informe_Para_Alumnos
 *
 */
@Entity

@NamedQueries({
    @NamedQuery(name="findInforme", query="select i from InformeActividades i where i.actividades= :a and i.alumno= :u" )
 	})

public class InformeActividades implements Serializable {

	public enum Estado {
	      EN_CURSO,
	      FINALIZADA
	};
	
	@Id @GeneratedValue
	private Long idInforme;
	private String informeProfesor;
	private String informeONG;
	private String valoracionAlumno;
	@Enumerated(EnumType.STRING)
	private Estado estado;
	
	@ManyToOne
	@JoinColumn(name = "profesorAsociado")
	private Profesor profesorAsociado; 
	
	@ManyToOne
	@JoinColumn(name = "alumno")
	private Alumno alumno;
	
	@ManyToOne
	@JoinColumn(name = "actividades")
	private Actividades actividades;

	
	private static final long serialVersionUID = 1L;

	public InformeActividades() {
		super();
	}   
	/*
	public InformeActividades(Long id, String ip, String io, Actividades a) {
        idInforme = id;
        informeProfesor = ip;
        informeONG = io;
        act = a;
    }
	
	public InformeActividades(Long id, String val, Actividades a) {
        idInforme = id;
        valoracionAlumno = val;
        act = a;
    }
	*/
	public Long getIdInforme() {
		return this.idInforme;
	}

	public void setIdInforme(Long idInforme) {
		this.idInforme = idInforme;
	}   
	public String getInformeProfesor() {
		return this.informeProfesor;
	}

	public void setInformeProfesor(String informeProfesor) {
		this.informeProfesor = informeProfesor;
	}   
	public String getInformeONG() {
		return this.informeONG;
	}

	public void setInformeONG(String informeONG) {
		this.informeONG = informeONG;
	}   
	public String getValoracionAlumno() {
		return this.valoracionAlumno;
	}

	public void setValoracionAlumno(String valoracionAlumno) {
		this.valoracionAlumno = valoracionAlumno;
	}
	public Profesor getProfe() {
		return profesorAsociado;
	}
	public void setProfe(Profesor profe) {
		this.profesorAsociado = profe;
	}
	
	public Actividades getAct() {
		return actividades;
	}
	
	public String getNombreAct() {
		return actividades.getNombreActividad();
	}
	
	public void setAct(Actividades act) {
		this.actividades = act;
	}
	
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Profesor getProfesorAsociado() {
		return profesorAsociado;
	}
	public void setProfesorAsociado(Profesor profesorAsociado) {
		this.profesorAsociado = profesorAsociado;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Actividades getActividades() {
		return actividades;
	}
	public void setActividades(Actividades actividades) {
		this.actividades = actividades;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idInforme == null) ? 0 : idInforme.hashCode());
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
		InformeActividades other = (InformeActividades) obj;
		if (idInforme == null) {
			if (other.idInforme != null)
				return false;
		} else if (!idInforme.equals(other.idInforme))
			return false;
		return true;
	}
	
	
	
}
