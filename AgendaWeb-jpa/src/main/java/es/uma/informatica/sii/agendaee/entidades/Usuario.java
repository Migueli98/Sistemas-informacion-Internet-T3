/*
Id * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.agendaee.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 *
 * @author francis
 */
@Entity
public class Usuario implements Serializable {
    
    public enum Rol {
      ADMIN,
      ALUMNO,
      PASPDI,
      ONG
    };
    
    @Id
    private String email;
	@Column(nullable = false)
	private String contraseña;
	
	private String nombre;
	private String apellido;
	@Enumerated(EnumType.STRING)
	private Rol rol;
	private static final long serialVersionUID = 1L;

	public Usuario() {
		super();
	}   
	
/*	public Usuario(Long ID, String EMAIL, String PASS, Rol R) {
		id=ID;
		email=EMAIL;
		contraseña=PASS;
		rol = R;
	}
	
	public Usuario(Long ID, String EMAIL, String PASS, Rol R, String n, String ap) {
		id=ID;
		email=EMAIL;
		contraseña=PASS;
		rol = R;
		nombre = n;
		apellido = ap;
	}
*/	
	   
	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}   
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String Nombre) {
		this.nombre = Nombre;
	}   
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String Apellido) {
		this.apellido = Apellido;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + email + ", rol=" + rol + "]";
	}
    
    
}
