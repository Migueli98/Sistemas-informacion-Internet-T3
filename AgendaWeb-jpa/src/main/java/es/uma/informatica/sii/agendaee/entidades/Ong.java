package es.uma.informatica.sii.agendaee.entidades;


import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Ong
 *
 */
@Entity

public class Ong extends Usuario {

	@Column(nullable = false)
	private String nombreONG;
	@Column(nullable = false)
	private String direccion;
	private String telefono;
	@Column(nullable = false)
	private String ciudad;
	@Column(nullable = false)
	private String pais;
	private String paginaWeb;
	private static final long serialVersionUID = 1L;

	public Ong() {
		super();
	}   
	/*
	public Ong(Long ID, String EMAIL, String PASS, Rol R, String n, String d, String c, String p) {
		super(ID, EMAIL, PASS, R);
		this.nombreONG = n;
		this.direccion = d;
		this.ciudad = c;
		this.pais = p;
	}
	*/
	
	public String getNombreONG() {
		return this.nombreONG;
	}

	public void setNombreONG(String nombreONG) {
		this.nombreONG = nombreONG;
	}   
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}   
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}   
	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}   
	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}   
	public String getPaginaWeb() {
		return this.paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}
   
}
