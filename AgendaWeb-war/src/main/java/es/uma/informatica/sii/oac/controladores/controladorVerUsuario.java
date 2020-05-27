package es.uma.informatica.sii.oac.controladores;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.sii.agendaee.entidades.Alumno;
import es.uma.informatica.sii.agendaee.entidades.Curriculum;
import es.uma.informatica.sii.agendaee.entidades.Usuario;
import es.uma.informatica.sii.oac.negocio.AprendizajeServicioException;
import es.uma.informatica.sii.oac.negocio.Negocio;




@Named(value ="controladorVerUsuario")
@RequestScoped
public class controladorVerUsuario implements Serializable{
	private ArrayList<Usuario> usuarios;
	private Usuario usuario;
	private Curriculum curriculum;
    
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
 
    
    
	public String getCurriculum(Alumno a) throws AprendizajeServicioException {
		//Curriculum cv = new Curriculum();
		curriculum = bd.findCurriculum(a.getCv().getId());
		//if(cv!=null) throw new AprendizajeServicioException(""+cv.getExperienciaLaboral());
		return "Curriculum.xhtml";
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
    
    
    
}
