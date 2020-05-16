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

public class InformeActividades implements Serializable {

	@Id @GeneratedValue
	private Long idInforme;
	private String informeProfesor;
	private String informeONG;
	private String valoracionAlumno;
	
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
	public Alumno getAlumn() {
		return alumno;
	}
	public void setAlumn(Alumno alumn) {
		this.alumno = alumn;
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
	
}
