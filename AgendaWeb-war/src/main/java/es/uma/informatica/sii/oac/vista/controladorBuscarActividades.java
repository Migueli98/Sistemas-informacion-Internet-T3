package es.uma.informatica.sii.oac.vista;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import es.uma.informatica.sii.agendaee.entidades.Actividades;
import es.uma.informatica.sii.agendaee.entidades.Actividades.Estado;


@Named(value ="controladorBuscarActividades")
@SessionScoped

public class controladorBuscarActividades implements Serializable{
	private ArrayList<Actividades> actividades;
	private Actividades actividad;
	public ArrayList<Actividades> getActividades() {
		return actividades;
	}
	public void setActividades(ArrayList<Actividades> actividades) {
		this.actividades = actividades;
	}
	public Actividades getActividad() {
		return actividad;
	}
	public void setActividad(Actividades actividad) {
		this.actividad = actividad;
	}

	public controladorBuscarActividades() throws ParseException{
		
	}
	
	public String borrarBuscarActividad(int id){
    	boolean encontrado =  false;
    	int cont = 0;
    	while(!encontrado) {
    		Actividades ac = actividades.get(cont);
    		if(ac.getIdActividad() == (id)) {
    			actividades.remove(cont);
    			encontrado = true;
    		}
    		cont++;
    	}
        return "buscarActividades.xhtml";
    }
	
	public Actividades getById(int id){
        return actividades.get(id);
    }
	
	public String verBuscarActividades(){
	     return "verBuscarActividades.xhtml";
	}
	
	public String inscribirseActividad() {
		return "buscarActividades.xhtml";
	}
	public String modificarBuscarActividad(){
        return "modificarBuscarActividad.xhtml";
    }
	
}
