/*
Id * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.agendaee.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/*@NamedQueries({
    @NamedQuery(name="buscarUsuario",query="select u from Usuario u where u.email=:email")
})
*/

@Entity

@NamedQueries({
    @NamedQuery(name="findAllUsuarios",query="select u from Usuario u"),
    @NamedQuery(name="findUsuarioId", query="select u from Usuario u where u.email= :id"),
    @NamedQuery(name="findAllUsuariosAP", query="select u from Usuario u where u.rol= :rol1 or u.rol= :rol2"),
    @NamedQuery(name="findAllProfesor", query="select u from Usuario u where u.rol= :rol")
	})

public class Usuario implements Serializable {
    
    public enum Rol {
      ADMIN,
      ALUMNO,
      PASPDI,
      ONG
    };
    
    @Id
    protected String email;
	@Column(nullable = false)
	private String contrasenia;
	
	private String nombre;
	private String apellido;
	@Enumerated(EnumType.STRING)
	private Rol rol;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="usuario")
	private List<Inscripciones> inscripciones;
	

	public Usuario() {
		super();
	}   
	
	public Usuario(String EMAIL, String PASS, Rol R) {
		email=EMAIL;
		contrasenia=PASS;
		rol = R;
	}
	
/*
	public Usuario(Long ID, String EMAIL, String PASS, Rol R, String n, String ap) {
		id=ID;
		email=EMAIL;
		contrase�a=PASS;
		rol = R;
		nombre = n;
		apellido = ap;
	}
*/	

	public String getEmail() {
		return email;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
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

	public List<Inscripciones> getInscripciones() {
		return inscripciones;
	}

	public void setInscripciones(List<Inscripciones> inscripciones) {
		this.inscripciones = inscripciones;
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

	@Override
	public String toString() {
		return "Usuario [usuario=" + email + ", rol=" + rol + "]";
	}
    
    
}
