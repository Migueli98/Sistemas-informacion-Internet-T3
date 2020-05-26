package es.uma.informatica.sii.agendaee.entidades;



import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Profesor
 *
 */
@Entity

public class Profesor extends Usuario {
	private static final long serialVersionUID = 1L;
	
	
	private String departamento;
	
	@ManyToMany()
	@JoinTable(name = "jnd_profesor_asignaturas",
	joinColumns = @JoinColumn(name = "profesor_fk"),
	inverseJoinColumns = @JoinColumn(name = "asignaturas_fk")
	)
	private List<Asignaturas> imparte = new ArrayList<Asignaturas>();
	
	@OneToMany(mappedBy="profesorAsociado")
	private List<InformeActividades> informes;
	

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

	public List<InformeActividades> getInformes() {
		return informes;
	}

	public void setInformes(List<InformeActividades> informes) {
		this.informes = informes;
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
	
	public void addAsignatura(Asignaturas a) {
		imparte.add(a);
		a.getImpartidoPor().add(this);
	}
	
	public void removeAsignatura(Asignaturas a) {
		imparte.remove(a);
		a.getImpartidoPor().remove(this);
	}


	@Override
	public int hashCode() {
		int result = super.hashCode();
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		return true;
	}
	
	
   
}
