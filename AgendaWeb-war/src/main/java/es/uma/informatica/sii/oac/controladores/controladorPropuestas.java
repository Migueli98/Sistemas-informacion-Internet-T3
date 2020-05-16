package es.uma.informatica.sii.oac.controladores;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import es.uma.informatica.sii.agendaee.entidades.Actividades;
import es.uma.informatica.sii.agendaee.entidades.Servicios;



@Named(value ="controladorPropuestas")
@RequestScoped
public class controladorPropuestas implements Serializable{
	private ArrayList<Actividades> actividades;
	private Actividades actividad;
	private ArrayList<Servicios> servicios;
	private Servicios servicio;
	
	public controladorPropuestas() throws ParseException{
		
	}

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

	public ArrayList<Servicios> getServicios() {
		return servicios;
	}

	public void setServicios(ArrayList<Servicios> servicios) {
		this.servicios = servicios;
	}

	public Servicios getServicio() {
		return servicio;
	}

	public void setServicio(Servicios servicio) {
		this.servicio = servicio;
	}
	
	//BORRAR
	public String borrarPropuestaActividad(int id){
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
        return "propuestas.xhtml";
    }
	
	public String borrarPropuestaServicio(int id){
    	boolean encontrado =  false;
    	int cont = 0;
    	while(!encontrado) {
    		Servicios ac = servicios.get(cont);
    		if(ac.getCodigoServicio() == (id)) {
    			servicios.remove(cont);
    			encontrado = true;
    		}
    		cont++;
    	}
        return "propuestas.xhtml";
    }
    
	
	
	
	//MODIFICAR
    public String modificarPropuestaActividad(){
        return "modificarPropuestaActividad.xhtml";
    }
    
    public String modificarPropuestaServicio(){
        return "modificarPropuestaServicio.xhtml";
    }
    //s
    //VER
    public String verPropuestaActividad(){
       return "verPropuestaActividad.xhtml";
     }
    
    public String verPropuestaServicio(){
        return "verPropuestaServicio.xhtml";
      }
    
    //GUARDAR
    public String guardarPropuestaActividad() {
    	return "propuesta.xhtml";
    }
    
    public String guardarPropuestaServicio() {
    	return "propuestas.xhtml";
    }
    
    //MODIFICAR
    public String crearPropuestaActividad(){
       return "crearPropuestaActividad.xhtml";
    }
    
    public String crearPropuestaServicio(){
        return "crearPropuestaServicio.xhtml";
     }
    
    
}
