package es.uma.informatica.sii.oac.vista;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import es.uma.informatica.sii.agendaee.entidades.Usuario;




@Named(value ="controladorVerUsuario")
@SessionScoped
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
    
    
/*	
	//borrar
	public String borrarUsuario(int id){
    	boolean encontrado =  false;
    	int cont = 0;
    	while(!encontrado) {
    		Usuario ac = usuarios.get(cont);
    		if(ac.getId() == (id)) {
    			usuarios.remove(cont);
    			encontrado = true;
    		}
    		cont++;
    	}
        return "verUsuariosAd.xhtml";
    }
 */   
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
