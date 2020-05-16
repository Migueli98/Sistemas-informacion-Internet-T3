package es.uma.informatica.sii.oac.vista;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import es.uma.informatica.sii.agendaee.entidades.Servicios;



@Named(value ="controladorProyectosAdPP")
@SessionScoped
public class controladorProyectosAdPP implements Serializable{
	private ArrayList<Servicios> servicios;
	private Servicios servicio;
	
    
    public controladorProyectosAdPP() throws ParseException{
    	
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
    
	//borrar
	public String borrarProyecto(int id){
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
        return "ProyectosAdPasPdi.xhtml";
    }
    
	//modificar
    public String modificarProyecto(){
     
        return "modificarProyecto.xhtml";
    }
    
    public Servicios getById(int id){
        return servicios.get(id);
    }
 
    //ver
    public String verProyecto(){
       return "verProyecto.xhtml";
    }
    
    //crear
    public String crearProyecto() {
    	return "crearProyecto.xhtml";
    }
    

}
