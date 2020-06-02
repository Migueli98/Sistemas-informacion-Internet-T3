package es.uma.informatica.sii.oac.controladores;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.sii.agendaee.entidades.Alumno;
import es.uma.informatica.sii.agendaee.entidades.Curriculum;
import es.uma.informatica.sii.agendaee.entidades.Inscripciones;
import es.uma.informatica.sii.agendaee.entidades.Ong;
import es.uma.informatica.sii.agendaee.entidades.Usuario;
import es.uma.informatica.sii.agendaee.entidades.Usuario.Rol;
import es.uma.informatica.sii.oac.negocio.AprendizajeServicioException;
import es.uma.informatica.sii.oac.negocio.Negocio;




@Named(value ="controladorVerUsuario")
@RequestScoped
public class controladorVerUsuario implements Serializable{
	private ArrayList<Usuario> usuarios;
	private Usuario usuario;
	private Curriculum curriculum;

	private String [] a = null;
    
	@Inject 
    private Negocio bd;
	    
	
    public controladorVerUsuario() throws ParseException{
    	curriculum = new Curriculum();
    }

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
    
    
    public Usuario getById(int id){
        return usuarios.get(id);
    }
 
    
    
	public String getCurriculum(Alumno a) {
		
		curriculum = bd.findCurriculum(a.getCv().getId());
		
		return "Curriculum.xhtml";
	}
	
	public String modificarCurriculum(Usuario a) throws AprendizajeServicioException {
		Alumno al = bd.findAlumno(a.getEmail());
		
		
		Curriculum c = bd.findCurriculum(al.getCv().getId());
		c.setDisponibilidad(curriculum.getDisponibilidad());
		c.setExperienciaLaboral(curriculum.getExperienciaLaboral());
		c.setIdiomas(curriculum.getIdiomas());
		bd.updateCurriculum(c);
		return "miPerfil.xhtml";
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}
	
	

	public Curriculum getCurriculum() {
		return curriculum;
	}

	//modificar
    public String modificarUsuario(){
     
        return "modificarUsuarioAd.xhtml";
    }

    //ver
    public String verUsuario(){
       return "verUsuario.xhtml";
    }
    
    //crear
    public String crearUsuario() {
    	return "crearUsuarioAd.xhtml";
    }
    
    public String guardarUsuario() {
    	
 	   	
 	   	bd.addUsuario(usuario);
    	
    	return "verUsuariosAd.xhtml";
    }
    
    public String borrarUsuario(String email) {
    	
    	
    	bd.deleteUsuario(bd.findUsuario(email));
    	
    	return "verUsuariosAd.xhtml";
    }
  
    public List<Usuario> allUsuarios(){
    	
    	return bd.allUsuario();
    	
    }
    
    public List<Usuario> allUsuariosAP(){
    	
    	return bd.allUsuarioAP();
    	
    }
    
    
    
    public Usuario inicializarUsuario() {
    	usuario = new Usuario();
    	usuario.setEmail("");
 	   	usuario.setRol(Rol.ALUMNO);
 	   	usuario.setApellido("");
 	   	usuario.setNombre("");
 	   	usuario.setContrasenia("");
 	   	usuario.setInscripciones(new ArrayList<Inscripciones>());

 	   return usuario;
    }
    
}
