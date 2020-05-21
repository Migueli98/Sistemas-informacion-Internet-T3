package es.uma.informatica.sii.oac.controladores;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import es.uma.informatica.sii.agendaee.entidades.Usuario;




@Named(value ="controladorVerUsuario")
@RequestScoped
public class controladorVerUsuario implements Serializable{
	private ArrayList<Usuario> usuarios;
	private Usuario usuario;
	
    
    public controladorVerUsuario() throws ParseException{
    	
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
    
    
	//modificar
    public String modificarUsuario(){
     
        return "modificarUsuarioAd.xhtml";
    }
    
    public Usuario getById(int id){
        return usuarios.get(id);
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
