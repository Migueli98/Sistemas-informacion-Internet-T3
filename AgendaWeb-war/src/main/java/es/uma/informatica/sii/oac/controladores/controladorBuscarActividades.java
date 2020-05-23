package es.uma.informatica.sii.oac.controladores;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.sii.agendaee.entidades.Actividades;
import es.uma.informatica.sii.agendaee.entidades.Actividades.Estado;
import es.uma.informatica.sii.agendaee.entidades.Inscripciones;
import es.uma.informatica.sii.agendaee.entidades.Inscripciones.estadoInscripcion;
import es.uma.informatica.sii.agendaee.entidades.Usuario;
import es.uma.informatica.sii.oac.negocio.Negocio;


@Named(value ="controladorBuscarActividades")
@RequestScoped

public class controladorBuscarActividades implements Serializable{
	private ArrayList<Actividades> actividades;
	private Actividades actividad;
	private Inscripciones ins;
	
	   @Inject 
	   private Negocio bd;
	
	public List<Actividades> getActividadesBP() {
		
		return bd.allActividadesEstado(Estado.BUSCANDO_PARTICIPANTES);
	}
	
	public String inscripcion(Usuario u) {
		
		ins = new Inscripciones();
		
		Date d = new Date();
		ins.setFechaInscripcion(d);
		ins.setEstado(estadoInscripcion.ESPERANDO);
		ins.setUsuario(u);
		ins.setActividad(bd.findActividades(actividad.getIdActividad()));
		ins.setActividad(actividad);
		
		bd.addInscripciones(ins);
		
		return "inscripcionActividad.xhtml";
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
	
	public String verBuscarActividades(Long id){
		actividad = bd.findActividades(id);
	    return "verBuscarActividades.xhtml";
	}
	
	public String inscribirseActividad() {
		return "buscarActividades.xhtml";
	}
	public String modificarBuscarActividad(){
        return "modificarBuscarActividad.xhtml";
    }
	
}
