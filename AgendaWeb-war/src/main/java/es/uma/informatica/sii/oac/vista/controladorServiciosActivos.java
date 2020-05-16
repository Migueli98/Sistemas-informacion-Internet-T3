package es.uma.informatica.sii.oac.vista;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import es.uma.informatica.sii.agendaee.entidades.Actividades;
import es.uma.informatica.sii.agendaee.entidades.Servicios;



@Named(value ="controladorServiciosActivos")
@SessionScoped
public class controladorServiciosActivos implements Serializable{
	private ArrayList<Actividades> actividades;
	private Actividades actividad;
	private ArrayList<Servicios> servicios;
	private Servicios servicio;
	
	public controladorServiciosActivos() throws ParseException{
		
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
	
	public String borrarServiciosActivos(int id){
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
        return "serviciosActivos.xhtml";
    }
    
	//MODIFICAR
    public String modificarServiciosActivos(){
        return "modificarServiciosActivos.xhtml";
    }
    
    //VER
    public String verServiciosActivos(){
        return "verServiciosActivos.xhtml";
    }
    
  //ACTIVIDADES
    public String actividadesServicios(){
        return "actividadesServicios.xhtml";
    }
    
  //VER ACTIVIDADES
    public String verActividadesServicios(){
        return "verActividadesServicios.xhtml";
    }
    
    //GUARDAR
    public String guardarServiciosActivos() {
    	return "ServiciosActivos.xhtml";
    }
    
    //MODIFICAR
    public String crearServiciosActivos(){
        return "crearServiciosActivos.xhtml";
     }
}
