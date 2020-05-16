package es.uma.informatica.sii.oac.controladores;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import es.uma.informatica.sii.agendaee.entidades.Ong;
import es.uma.informatica.sii.agendaee.entidades.Usuario.Rol;



@Named(value ="controladorVerOng")
@RequestScoped
public class controladorVerOng implements Serializable{
	private ArrayList<Ong> ongs;
	private Ong ong;
	
	public controladorVerOng() throws ParseException{
		
		
	}

	public ArrayList<Ong> getOngs() {
		return ongs;
	}

	public void setOngs(ArrayList<Ong> ongs) {
		this.ongs = ongs;
	}

	public Ong getOng() {
		return ong;
	}

	public void setOng(Ong ong) {
		this.ong = ong;
	}

	/*
	//borrar
	public String borrarOng(int id){
    	boolean encontrado =  false;
    	int cont = 0;
    	while(!encontrado) {
    		Ong ac = ongs.get(cont);
    		if(ac.getId() == (id)) {
    			ongs.remove(cont);
    			encontrado = true;
    		}
    		cont++;
    	}
        return "verOngsAd.xhtml";
    }
    */
    
	//modificar
    public String modificarOng(){
     
        return "modificarOngAd.xhtml";
    }
    
    public Ong getById(int id){
        return ongs.get(id);
    }
 
    //ver
    public String verOng(){
       return "verOng.xhtml";
    }
    
    //crear
    public String crearOngAd() {
    	return "crearOngAd.xhtml";
    }
}
