package es.uma.informatica.sii.agendaee.entidades;




import java.lang.Integer;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Alumno
 *
 */
@Entity

public class Alumno extends Usuario{


	private Integer creditos;
	private Integer horasLibre;
	
	@OneToOne(mappedBy="alumno")
	private Curriculum cv;
	
	@ManyToMany
	private List<Asignaturas> matriculadoEn;
	
	
	@OneToMany(mappedBy="alumno")
	private List<InformeActividades> informes;
	
	private static final long serialVersionUID = 1L;

	public Alumno() {
		super();
	}   
/*
	public Alumno(Long ID, String EMAIL, String PASS, Rol R, String nombre, String apellido, Integer c, Integer hL) {
		super(ID, EMAIL, PASS, R, nombre, apellido);
		this.creditos = c;
		this.horasLibre = hL;
		
	}
	
	public Alumno(Long ID, String EMAIL, String PASS, Rol R, String nombre, String apellido, Integer c, Integer hL, Curriculum cv) {
		super(ID, EMAIL, PASS, R, nombre, apellido);
		this.creditos = c;
		this.horasLibre = hL;
		this.cv = cv;
	}
*/	
	public Integer getCreditos() {
		return this.creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}   
	public Integer getHorasLibre() {
		return this.horasLibre;
	}

	public void setHorasLibre(Integer horasLibre) {
		this.horasLibre = horasLibre;
	}
	public Curriculum getCv() {
		return cv;
	}
	public void setCv(Curriculum cv) {
		this.cv = cv;
	}
	public List<Asignaturas> getMatriculadoEn() {
		return matriculadoEn;
	}
	public void setMatriculadoEn(List<Asignaturas> matriculadoEn) {
		this.matriculadoEn = matriculadoEn;
	}
	public List<InformeActividades> getInformes() {
		return informes;
	}
	public void setInformes(List<InformeActividades> informes) {
		this.informes = informes;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}
	
   
	
}
