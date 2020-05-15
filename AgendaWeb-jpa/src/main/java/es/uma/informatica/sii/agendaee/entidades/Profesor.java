package es.uma.informatica.sii.agendaee.entidades;



import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Profesor
 *
 */
@Entity

public class Profesor extends Usuario {

	@Column(nullable = false)
	private String departamento;
	
	@ManyToMany
	private List<Asignaturas> imparte;
	
	private static final long serialVersionUID = 1L;

	public Profesor() {
		super();
	}   
	/*
	public Profesor(Long ID, String EMAIL, String PASS, Rol R, String n, String ap,String d) {
		super(ID, EMAIL, PASS, R, n,ap);
		this.departamento = d;	
	}
	*/
	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public List<Asignaturas> getImparte() {
		return imparte;
	}
	public void setImparte(List<Asignaturas> imparte) {
		this.imparte = imparte;
	}
   
}
