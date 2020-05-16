package es.uma.informatica.sii.agendaee.entidades;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Asignaturas
 *
 */
@Entity

public class Asignaturas implements Serializable {

	   
	@Id @GeneratedValue
	private Long codigoAsignatura;
	@Column(nullable = false)
	private Integer creditos;
	@Column(nullable = false)
	private String nombreAsignatura;
	
	@ManyToOne
	@JoinColumn(name = "centro")
	private Centro ensenia;
	
	@ManyToMany(mappedBy = "matriculadoEn")
	private List<Alumno> estaCursando;
	
	@ManyToMany(mappedBy = "imparte")
	private List<Profesor> impartidoPor;
	
	@ManyToMany(mappedBy = "compuestoDe")
	private List<Curriculum> incluidasEn;
	
	@ManyToMany(mappedBy = "requieren")
	private List<Requisitos> compuestoDe;
	
	
	private static final long serialVersionUID = 1L;

	public Asignaturas() {
		super();
	}   
	
	/*
	public Asignaturas(Long cA, Integer cr, String nA) {
		
		this.codigoAsignatura = cA;
		this.creditos = cr;
		this.nombreAsignatura = nA;
	}
	*/
	public Long getCodigoAsignatura() {
		return this.codigoAsignatura;
	}

	public void setCodigoAsignatura(Long codigoAsignatura) {
		this.codigoAsignatura = codigoAsignatura;
	}   
	public Integer getCreditos() {
		return this.creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}   
	public String getNombreAsignatura() {
		return this.nombreAsignatura;
	}

	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}
	public List<Alumno> getEstaCursando() {
		return estaCursando;
	}
	public void setEstaCursando(List<Alumno> estaCursando) {
		this.estaCursando = estaCursando;
	}
	public List<Profesor> getImpartidoPor() {
		return impartidoPor;
	}
	public void setImpartidoPor(List<Profesor> impartidoPor) {
		this.impartidoPor = impartidoPor;
	}
	public Centro getEnsenia() {
		return ensenia;
	}
	public void setEnsenia(Centro ensenia) {
		this.ensenia = ensenia;
	}
	public List<Curriculum> getIncluidasEn() {
		return incluidasEn;
	}
	public void setIncluidasEn(List<Curriculum> incluidasEn) {
		this.incluidasEn = incluidasEn;
	}
	public List<Requisitos> getCompuestoDe() {
		return compuestoDe;
	}
	public void setCompuestoDe(List<Requisitos> compuestoDe) {
		this.compuestoDe = compuestoDe;
	}
   
}
